package com.pyshy.lgmanager;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: zhoutong
 * @date: Created in 2018/11/2
 */
public class XmlReader {

    public Map<String,Object> getFieldsName(Class clas, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String,Object> map = new HashMap<String,Object>();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(clas);
        pool.insertClassPath(classPath);
        CtClass cc = pool.get(clazzName);
        CtMethod cm  = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attribute = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if(attribute == null){
            //Exception
        }
        int pos = Modifier.isStatic((cm.getModifiers())) ? 0 : 1;
        for(int i = 0 ; i < cm.getParameterTypes().length ; i++){
            map.put(attribute.variableName(i+pos),args[i]);
        }
        return map;
    }

    public void getLocalData(Object object) throws ClassNotFoundException, IllegalAccessException {
        String classType = object.getClass().getName();
        Class<?> clazz = Class.forName(classType);
        System.out.println("method ---------------start");
        for(Method m :clazz.getMethods()){
            System.out.println(m.getName());
        }
        System.out.println("method ---------------end");
        String clazzName = clazz.getName();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for(Field f : declaredFields){
            f.setAccessible( true );
            Object val = f.get(object);
            System. out .println( "name:" +f.getName()+ "/t value = " +val);
            String type = f.getType().toString();
            System.out.println(type);

        }
    }
    public String toString(Document document) {
        return "[" + document.getNodeName() + ": " + document.getNodeValue() + "]";
    }

    public XmlReader() {
        DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder domBuilder = domfac.newDocumentBuilder();
            InputStream is = new FileInputStream(new File(
                    "D://test.xml"));
            Document doc =  domBuilder.parse(is);
            getLocalData(doc);
            System.out.println(toString(doc));
            Element root = doc.getDocumentElement();
            NodeList users = root.getChildNodes();
            if (users != null) {
                for (int i = 0; i < users.getLength(); i++) {
                    Node user = users.item(i);
                    // TEXT_NODE 说明该节点是文本节点

                    if (user.getNodeType() == Node.ELEMENT_NODE) {

                        for (Node node = user.getFirstChild(); node != null; node = node
                                .getNextSibling()) {
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                if (node.getNodeName().equals("name")) {
                                    String name = node.getNodeValue();
                                    String name1 = node.getFirstChild()
                                            .getNodeValue();
                                    System.out.println("name==" + name);
                                    System.out.println("name1==" + name1);
                                    NodeList childNodes = node.getChildNodes();
                                    System.out.println("--------------------------------");
                                    for(int x = 0 ; x < childNodes.getLength() ; x++){
                                        System.out.println(childNodes.item(x));
                                    }
                                    System.out.println("--------------------------------");
                                }
                                if (node.getNodeName().equals("price")) {
                                    String price = node.getFirstChild()
                                            .getNodeValue();
                                    System.out.println(price);
                                }
                            }
                        }
                    }
                }
            }
            NodeList node = root.getElementsByTagName("string");
            if (node != null) {
                for (int i = 0; i < node.getLength(); i++) {
                    Node str = node.item(i);
                    String s = str.getFirstChild().getNodeValue();
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        XmlReader xmlReader = new XmlReader();
    }
}

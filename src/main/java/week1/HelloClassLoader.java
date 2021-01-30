package week1;

import java.io.IOException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {


public static void main(String[]args){

    try {
       Class aClass= new HelloClassLoader().findClass("Hello");

        Method method =aClass.getMethod("hello");
        method.invoke(aClass.newInstance());
    } catch (Exception e){
        e.printStackTrace();
    }

}

    @Override
    protected Class<?> findClass(String name)  {

   //String helloBase64="yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQALTGp2bS9IZWxsbzsBAAg8Y2xpbml0PgEACGxvIENsYXNzIEluaXRpYWxpemVkIQcAHAwAHQAeAQAJanZtL0hlbGxvAQAQamF2YS9YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgABAAkAAAAvAAEAAQAAAAUqtwABsQAAAAIACgAAAAYAAQAAAAMACwAAAAwAAQAAAAUAAAAACgACAAAABgAIAAcAAQAPAAAAAgAQ";
        byte[] bytes=null;
        try {
            bytes = FileUtils.getContent("/Users/zhangxin/Desktop/demo/src/Hello.xlass");
            bytes =decode(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,bytes,0,bytes.length);
    }


   private static byte[] decode(byte[] byteArray) {
       byte[] targetArray = new byte[byteArray.length];
       for (int i = 0; i < byteArray.length; i++) {
           targetArray[i] = (byte) (255 - byteArray[i]);
       }
       return targetArray;
   }



}



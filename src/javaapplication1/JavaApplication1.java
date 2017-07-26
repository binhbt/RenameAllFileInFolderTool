/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;

/**
 *
 * @author leobui
 */
public class JavaApplication1 {
    private static final String NEW_NAME_ARR ="3|2|1";
    private static final String NEW_PREFIX ="aa";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        changeAllFileName("C://test", ".txt");
    }
    //D://xyz
    private static void changeAllFileName(String folder, String type){
        String[] names = NEW_NAME_ARR.split("|");
        if(names != null && names.length >0){
            for(int i=0; i<names.length; i++){
                changeFileNumber(folder,type, NEW_PREFIX, names[i], i+"");
            }
        }
    }
    private static void changeFileNumber(String folder, String type,  String newPrefix, String oldIdx, String newIdx){
        File dir = new File(folder);

        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles()) {
                try {
                    String oldName = f.getName();
                    String[] oldNames = oldName.split("_");
                    if (oldNames != null && oldNames.length >0) {
                        if (oldNames[1] != null) {
                            if(oldNames[1].equals(oldIdx+type)){
                                File newfile =new File(newPrefix+newIdx+type);
                                if(f.renameTo(newfile)){
                                    System.out.println("Rename succesful");
                                }else{
                                    System.out.println("Rename failed");
                                }
                                break;
                            }
                                    
                        }
                    }

                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}

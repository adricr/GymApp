package com.ac.helper;

import com.ac.model.Member;

import java.io.*;

public class CSVFileOperations {
    private File file;

    /**
     * Class Constructor
     * @param filepath the file name
     */
    public CSVFileOperations(String filepath){
        this.file = new File(filepath);
    }
    public void writeMemberToCSV(Member member) throws IOException{
        if(!file.exists()){
            file.createNewFile();
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
            writer.println(member.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getLastIdFromCSV(File file) throws IOException{
        if (!file.exists()) {
            return -1;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            int lastId = 0;
            while((line = reader.readLine()) != null){
                String [] parts = line.split(",");
                if (!line.equals("")) {
                    lastId = Integer.parseInt((parts[0]));
                }
            }
            return lastId + 1; //return last id plus one
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }

    }


}

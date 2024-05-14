package com.ac.controller;
import com.ac.model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberController {

    private final File memberFile = new File("members.csv");

    //Stores a record in the file
    public void store(Member member) throws IOException {
        /* check if the file doesnt exist */
        if(member.getMemberId().equals(String.format("%07d",-1))){
            member.setMemberId(String.format("%07d",1));
            memberFile.createNewFile();

        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(memberFile,true))){
            writer.println(member.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method returns all the users from a csv file
     * @return ArrayList of type Member
     * @throws IOException
     */
    public ArrayList<Member> getAllMembersFromCSV() throws IOException {
        ArrayList<Member> memberArrayList = new ArrayList<Member>();
        if (!memberFile.exists()) {
            memberArrayList.clear();
            return memberArrayList;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(memberFile))){
            String line;
            //read all lines from the file
            while((line = reader.readLine()) != null){
                //split lines in strings
                String [] parts = line.split(",");
                //Create a new member with the parts of the string that represent the username and the password
                switch (parts[7]){
                    case "STANDARD":
                        memberArrayList.add(new Member(parts[0],parts[2],parts[3],parts[4],parts[5],parts[6],new StandardMembership(parts[1], LocalDate.parse(parts[9]))));
                        break;
                    case "PREMIUM":
                        memberArrayList.add(new Member(parts[0],parts[2],parts[3],parts[4],parts[5],parts[6],new PremiumMembership(parts[1], LocalDate.parse(parts[9]))));
                        break;
                    case "VIP":
                        memberArrayList.add(new Member(parts[0],parts[2],parts[3],parts[4],parts[5],parts[6],new VIPMembership(parts[1], LocalDate.parse(parts[9]))));
                        break;
                }
            }
            return memberArrayList; //return arraylist of users
        }catch (IOException e){
            e.printStackTrace();
            memberArrayList.clear();
            return memberArrayList;
        }

    }

    /**
     * This method returns the first instance found that uses the Id provided
     * @param id String with the Id to look for
     * @return the first member with this name
     * @throws RuntimeException when no member is found
     */
    public Member getMemberFromCSVById(int id) throws RuntimeException{
        ArrayList<Member> memberArrayList = new ArrayList<Member>();
        String idString = String.format("%07d",id);
        try {
            memberArrayList.addAll(getAllMembersFromCSV());
            //for each member in memberArrayList check if the membername is the same
            for (Member member : memberArrayList) {
                if (member.getMemberId().equals(idString)) {
                    return member;
                }
            }
            throw new RuntimeException("No member Found with Id ".concat(idString));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

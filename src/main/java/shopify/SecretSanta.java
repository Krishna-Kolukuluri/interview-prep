package shopify;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//import javax.activation.*;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecretSanta {
    public static String from = "deepu@gmail.com";
    public static String appPassword = "you_thought_lmao";
    public static String inputFile = "C://Users//KANTIPDX//Documents//santaSecret.csv";
    private static ArrayList<Person> people;

    public static void populatePeople() {
        people = new ArrayList<Person>();
        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null) {
                String temp = "";
                Person p = new Person();
                int counter = 0;
                for(int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ',') {
                        if(counter == 0) {
                            p.setName(temp);
                            counter++;
                        } else {
                            p.setEmail(temp);
                        }
                        temp = "";
                    } else {
                        temp += line.charAt(i);
                    }
                }
                p.setGift(temp);
                people.add(p);
                line = br.readLine();
            }
            fr.close();
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("fnfe: " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ioe: " + ioe.getMessage());
        }
    }

    public static void generateRandomGiftConnections() {
        HashMap<String,String> finalList=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        int i=0;
        while(finalList.size()<people.size()){
            if(i<people.size()){
                int[] ex={i};
                int j = generateRandom(0,people.size(),ex);
                if(!set.contains(j)){
                    set.add(j);
                    finalList.put(people.get(j).getEmail(),people.get(i).getGift());
                    i++;
                }
                
            }
        }

        System.out.println(finalList.size());
        finalList.forEach((k,v)->{System.out.println(k+"  :  "+v);});
    }
    public static int generateRandom(int start, int end, int... excludes){
        Random rand=new Random();
        int rangeLength = end - start - excludes.length;
        int randomInt = rand.nextInt(rangeLength) + start;

        for(int i = 0; i < excludes.length; i++) {
            if(excludes[i] > randomInt) {
                return randomInt;
            }

            randomInt++;
        }

        return randomInt;
    }

    /**public static void generateConnections() {
        //generating the directed edges
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(Integer j = 0; j < people.size(); j++) {
            numbers.add(j);
        }
        ArrayList<Integer> choices = new ArrayList<Integer>();

        int choice;
        Integer start, temp;
        Random rand = new Random();
        choice = rand.nextInt(numbers.size());
        choices.add(numbers.get(choice));
        start = numbers.get(choice);
        System.out.println(start);
        numbers.remove(choice);
        boolean selfLoop = true;
        boolean pickStart = false;
        while(numbers.size() > 2 || pickStart) {
            rand = new Random();
            choice = rand.nextInt(numbers.size());
            choices.add(numbers.get(choice));
            temp = numbers.get(choice);
            numbers.remove(temp);
            if(selfLoop && !pickStart) {
                selfLoop = false;
                numbers.add(start);
            } 
            else if (!selfLoop && pickStart) {
                start = temp;
                pickStart = false;
                selfLoop = true;
            } 
            else {
                if(temp == start) {
                    pickStart = true;
                }
            }
        }
        if(selfLoop && numbers.size() == 2) {
            choice = rand.nextInt(2);
            choices.add(numbers.get(choice));
            choices.add(numbers.get(1-choice));
            choices.add(start);
        } else {
            if(numbers.get(0) == start) {
                choices.add(numbers.get(1));
                choices.add(start);
            } else {
                choices.add(numbers.get(0));
                choices.add(start);
            }
        }

        pickStart = true;
        start = choices.get(0);
        for(int b = 0; b < choices.size(); b++) {
            if(!pickStart) {
                people.get(choices.get(b-1)).setGiving(people.get(choices.get(b)));
                if(choices.get(b).equals(start)) {
                    pickStart = true;
                }
            } else {
                start = choices.get(b);
                pickStart = false;
            }
        }
    }**/

    public static void printParticipants() {
        for(int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).getName());
        }
    }

    public static void printConnections() {
        try {
            for(int i = 0; i < people.size(); i++) {
                System.out.println(people.get(i).getName() + " is giving a gift to " + people.get(i).getGiveTo().getName());
            }
        } catch(NullPointerException npe) {
            System.out.println("Not every user was assigned. Try again.");
        }

    }

    /**
    public static void sendEmails() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465"); 

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                                @Override
                protected PasswordAuthentication getPasswordAuthentication() { 
                    return new PasswordAuthentication(from, appPassword);
                }
            });

        try {
            for(int a = 0; a < people.size(); a++) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(people.get(a).getEmail()));
                message.setSubject("Secret Santa");
                String emailBody = "Hello " + people.get(a).getName() + "!\n";
                emailBody += "\n";
                emailBody += "You are giving a gift to " + people.get(a).getGiveTo().getName() + ".\n";
                emailBody += "\n";
                emailBody += "Gift Suggestion(s): " + people.get(a).getGiveTo().getGift() + "\n";
                message.setText(emailBody);
                Transport.send(message);
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
     **/
    public static void main(String[] args) {
        System.out.println("Sending out emails with account: " + from);
        System.out.println("Pulling participant information from input file: " + inputFile);
        populatePeople();
        generateRandomGiftConnections();
        System.out.println("Assignment generation complete.");
        //        sendEmails();
    }
}
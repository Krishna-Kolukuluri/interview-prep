package ds.dstype;


import ds.models.DVD;

public class ArrayType {


    public static void main(String[] args) {
        DVD[] dvdCollection = new DVD[15];
        System.out.println(dvdCollection.length);
        DVD avengersDvd = new DVD("The Avengetrs", 2012, "Joss Whedon");
        dvdCollection[7] = avengersDvd;
        System.out.println(dvdCollection[7]);
        DVD incrediblesDvd = new DVD("The Incredibles", 2004, "Brad Bird");
        DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
        DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");
        dvdCollection[3] = incrediblesDvd;
        System.out.println(dvdCollection[3]);
        dvdCollection[9] = findingDoryDVD;
        System.out.println(dvdCollection[9]);
        dvdCollection[2] = lionKingDVD;
        System.out.println(dvdCollection[2]);
        DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
        dvdCollection[3] = starWarsDVD;
        System.out.println(dvdCollection[3]);

        int[] squareNumbers = new int[10];
        for(int index=0;index<squareNumbers.length;index++){
            squareNumbers[index] = (index + 1) * (index + 1);
            System.out.println("Square of '" + (index + 1) + "'" + " is '" + squareNumbers[index] + "'" );
        }
        for(int square: squareNumbers){
            System.out.println(square);
        }
    }

}

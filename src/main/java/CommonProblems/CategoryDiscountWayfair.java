package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
find a coupon for a category and if the coupon does not exist check for parent category.
eg if there is no coupon for bedding , check who is the parent of bedding and return their coupon
Input:
* */
public class CategoryDiscountWayfair {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("indoor  ");
        strs.add("mat bed 5");
        strs.add("bed home 7");
        strs.add("bath home ");
        strs.add("kitchen home 6");
        strs.add("patio outdoor ");
        strs.add("outdoor home ");
        strs.add("home  10");
        strs.add("office indoor ");

        System.out.println(getCategoryDiscount(strs, "office"));
    }

    public static int getCategoryDiscount(List<String> catParDiscounts, String catName){
        HashMap<String, Discount> map = getDiscountMap(catParDiscounts);
        return getDiscount(map,catName, 0);
    }

    //'\\s' splits strings for each space occurrence
    //'\\s+' splits strings  one or more spaces consecutively together as one split
    public static HashMap<String, Discount> getDiscountMap(List<String> catParDiscounts){
        HashMap<String, Discount> discountHashMap = new HashMap<>();
        for(String cat: catParDiscounts){
            String[] det = cat.split("\\s");
            Discount discount = new Discount();
            discount.setCatName(det[0]);
            if(det.length>=2){
                discount.setParentCatName(det[1]);
            }
            else {
                discount.setParentCatName(" ");
            }
            if(det.length == 3){
                if(det[2].equals(" ")){
                    discount.setDiscountVal(-1);
                }else {
                    discount.setDiscountVal(Integer.parseInt(det[2]));
                }
            }
            else{
                discount.setDiscountVal(-1);
            }
            discountHashMap.put(discount.getCatName(), discount);
        }
        return discountHashMap;
    }

    public static int getDiscount(HashMap<String, Discount> discountMap, String catName, int recCount){

        if(recCount >=discountMap.size()){
            //It means there is cycle between few categories with no discount on any one of them.
            return -1;
        }
        if(discountMap.containsKey(catName)){
            Discount discount = discountMap.get(catName);
            if(discount.getDiscountVal() != -1){
                return discount.getDiscountVal();
            }
            return getDiscount(discountMap, discount.getParentCatName(), recCount + 1);
        }
        else{
            //given category/parent category doesn't available in input.
            return -1;
        }
    }
}
class Discount{
    private String catName;
    private String parentCatName;
    private int discountVal = -1;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getParentCatName() {
        return parentCatName;
    }

    public void setParentCatName(String parentCatName) {
        this.parentCatName = parentCatName;
    }

    public int getDiscountVal() {
        return discountVal;
    }

    public void setDiscountVal(int discountVal) {
        this.discountVal = discountVal;
    }
}

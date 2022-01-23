package CommonProblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*
Given a menu card and an amount, how many dishes can I afford to eat/drink at the restaurant.
Return all such combinations of dishes from the menu, which I can pay for in given amount.

Explanation:
Menu:
Noodle  $12.87
Rice    $8.23
Soup    $5.76
Coke    $3.12
Pizza   $10.89

Amount:  $30

Output:
{{Noodle,Rice,Soup,Coke},
{Noodle,Pizza,Soup},
{Pizza,Rice,Soup,Coke},
{Noodle,Noodle,Coke},
{Noodle,Rice,Rice},
{Rice,Rice,Rice,Coke},
{Soup,Soup,Soup,Pizza},
{Coke,Coke...9x},
{Pizza,Pizza,Coke,Coke}}

As,
Noodle+Rice+Soup+Coke = 29.98
Noodle+Pizza+Soup = 29.52
Pizza+Rice+Soup+Coke = 28 ...so on

Note: The amount we aggregate should be closest to the given amount i.e in this case $30
* */
public class CombinationOfMenuItemPrices {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>(Arrays.asList("Noodle","Rice","Soup", "Coke", "Pizza"));
        List<Double> prices = new ArrayList<>(Arrays.asList(12.87,8.23,5.76,3.12,10.89));
        double total = 30;
        MenuCombination menuCombination = new MenuCombination();
        List<List<String>> orders = menuCombination.allItemCombinationOrders(items, prices, total);
        for(List<String> order : orders){
            System.out.println(order);
        }
    }
}
class MenuCombination {
    public List<List<String>> allItemCombinationOrders(List<String> menuItems, List<Double> prices, Double total){
        List<String> order = new ArrayList<>();
        List<MenuItem> menu = getMenuPrices(menuItems, prices);
        HashMap<String, List<String>> uniqueOrders = new HashMap<>();
        dfs(order, menu, total, uniqueOrders);
        List<List<String>> stream = new ArrayList<> (uniqueOrders.values());
        return stream;
    }

    private List<MenuItem> getMenuPrices(List<String> menuItems, List<Double> prices){
        List<MenuItem> menu = new ArrayList<>();
        for(int i=0; i<menuItems.size();i++){
            MenuItem menuItem = new MenuItem();
            menuItem.itemName = menuItems.get(i);
            menuItem.price = prices.get(i);
            menu.add(menuItem);
        }
        Collections.sort(menu, (A,B) -> (int) (A.price - B.price));
        return menu;
    }

    private void dfs(List<String> order, List<MenuItem> menu, double total, HashMap<String, List<String>> uniqueOrders){
        if(total == 0 || total< menu.get(0).price){
            List<String> confirmed = new ArrayList<>(order);
            String orderKey = orderString(confirmed);
            if(!uniqueOrders.containsKey(orderKey)){
                uniqueOrders.put(orderKey, confirmed);
            }
            return;
        }
        if(total < 0){
            return;
        }
        for(int i = 0; i<menu.size(); i++){
            order.add(menu.get(i).itemName);
            dfs(order, menu, total - menu.get(i).price,uniqueOrders);
            order.remove(order.size() - 1);
        }
    }

    private String orderString(List<String> order){
        StringBuilder sb = new StringBuilder();
        Collections.sort(order);
        for(String str: order){
            sb.append(str);
        }
        return sb.toString();
    }
}

class MenuItem {
    String itemName;
    double price;
}

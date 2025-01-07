class SearchSuggestionSystem {
   
   int findStartPrefix(int startIndex,String[] products,String prefix){
    int start=0;
    int end=products.length;
    int mid=end/2;
    while(start<end){
        mid=(end+start)/2;
        if(products[mid].compareTo(prefix)>=0){
            end=mid;
        }
        else{
            start=mid+1;
        }
    }
    return start;
    }

    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        char[] chArr=searchWord.toCharArray();
         List<List<String>> result=new ArrayList<>();

        String prefix="";
        int startIndex=0;

        for(char c:chArr){
         prefix+=c;
         int start=findStartPrefix(startIndex,products,prefix);
          
       
        result.add(new ArrayList<>());

        for(int i=start;i< Math.min(start+3,products.length);i++){
            if(products[i].length() < prefix.length() || !products[i].substring(0,prefix.length()).equals(prefix)){
                break;
            }
            result.get(result.size()-1).add(products[i]);
        }
        startIndex=start;

        }
        return result;
    }
}

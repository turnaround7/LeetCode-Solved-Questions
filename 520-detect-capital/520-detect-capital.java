class Solution {
      private static boolean isStringUpperCase(String str){
        char[] charArray = str.toCharArray();
        for(int i=0; i < charArray.length; i++){
        if( !Character.isUpperCase( charArray[i] ))
                return false;
         }
         return true;
        }
    
       private static boolean isStringLowerCase(String str){
        char[] charArray = str.toCharArray();
        for(int i=0; i < charArray.length; i++){
        if( !Character.isLowerCase( charArray[i] ))
                return false;
         }
       return true;
        }
    
    public boolean detectCapitalUse(String word) {
         if(isStringUpperCase(word))
             return true;
        if(isStringLowerCase(word))
            return true;
        if(isStringUpperCase(word.substring(0,1))&&isStringLowerCase(word.substring(1)))
            return true;
        return false;
        
        
    }
}
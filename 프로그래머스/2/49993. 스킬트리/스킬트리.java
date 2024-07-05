class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        StringBuilder sb;
        for(String tree : skill_trees){
            sb = new StringBuilder();
            for(int i=0; i<tree.length(); i++){
                if (skill.contains(Character.toString(tree.charAt(i))))
                    sb.append(tree.charAt(i));
            }

            if (isSub(skill, sb.toString()))
                result++;
        }
       return result;
    }
    
    public static boolean isSub(String skill, String target){
        int i = 0;
        int len = Math.min(skill.length(), target.length());
        while(i < len){
            if (skill.charAt(i) != target.charAt(i))
                return false;
            i++;
        }
        return true;
    }
}
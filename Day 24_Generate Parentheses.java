class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        findAll("(",1,0,result,n);
        return result;
    }
    void findAll(String current,int i,int j, List<String> result,int n)
    {
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        if(i<n)findAll(current+"(",i+1,j,result,n);
        if(j<i)findAll(current+")",i,j+1,result,n);
    }
}
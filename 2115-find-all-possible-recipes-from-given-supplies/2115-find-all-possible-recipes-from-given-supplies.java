class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        boolean progress = true;
        while (progress){
            progress = false;
            for (int i = 0; i < recipes.length; i++) {
                if (ans.contains(recipes[i])) continue;
                List<String> ingList = ingredients.get(i);
                if (available.containsAll(ingList)) {
                    ans.add(recipes[i]);
                    available.add(recipes[i]);
                    progress = true;
                }
            }
        }
        return ans;
    }
}
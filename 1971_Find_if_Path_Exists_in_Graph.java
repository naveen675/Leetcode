//https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution {

    public boolean util(ArrayList<ArrayList<Integer>> graph, boolean [] visited, boolean [] path, int v, int source, int destination){


        path[v] = true;
        visited[v] = true;

        if(path[source] && path[destination] ){

            return true;
        }

        for(Integer i : graph.get(v)){

                if(visited[i] == false){

                 if(util(graph, visited, path, i, source, destination)){  return true;};
                }

        }

        path[v] = false;
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int len = edges.length;
        int N = n;
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        boolean [] visited=  new boolean[N];
        boolean [] path = new boolean[N];

        for(int i=0; i<n; i++){

            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){

                int v = edges[i][0];
                int e = edges[i][1];

                graph.get(v).add(e);
                graph.get(e).add(v);

        }

        if(util(graph, visited, path, source, source, destination)){
            return true;
        }
        return false;   
    }
}
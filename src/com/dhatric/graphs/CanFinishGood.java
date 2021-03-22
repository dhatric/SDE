package com.dhatric.graphs;

import java.util.ArrayList;
import java.util.List;

class CanFinsihGood {
    int visited[],count;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        
        visited=new int[numCourses];
       
        ArrayList<Integer>[] adjList=new ArrayList[numCourses];
        
        
        
        for(int i=0;i<numCourses;i++)
            adjList[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
                adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int i=0;i<numCourses;i++){
                //if dfs() is false it means cycle detected
                if(DFS(adjList, i)){
                    return false;
            }
        }
        return true;
    }

    
    public boolean DFS(List<Integer>[] adjList, int v){
        
        //cycle present as this vertex is in visiting/processing state
        if(visited[v]==1)return true;
        
        else if(visited[v]==2)return false;
        
        visited[v]=1;
        
        for(int i=0;i<adjList[v].size();i++){
            if(DFS(adjList, adjList[v].get(i))){
                return true;
            }
        }
        
        visited[v]=2;
        
        return false;
    }
}
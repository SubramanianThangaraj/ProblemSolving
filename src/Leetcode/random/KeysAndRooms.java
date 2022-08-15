/**
 * Problem Link: https://leetcode.com/problems/consecutive-numbers-sum/
 */

package Leetcode.random;

import java.util.List;

public class KeysAndRooms
{
    int visitedRooms;
    boolean[] isVisited;
    int totalRooms;
    List<List<Integer>> rooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        this.rooms = rooms;
        totalRooms = rooms.size();
        isVisited = new boolean[rooms.size()];
        isVisited[0] = true;
        visitedRooms = 1;
        int isPossible = visit(rooms.get(0));
        if(isPossible == totalRooms)return true;
        return false;
    }


    public int visit(List<Integer> room)
    {
        for(int roomKey : room)
        {
            if(!isVisited[roomKey]){
                visitedRooms++;
                isVisited[roomKey] = true;
                visit(rooms.get(roomKey));
            }
        }
        return visitedRooms;
    }
}

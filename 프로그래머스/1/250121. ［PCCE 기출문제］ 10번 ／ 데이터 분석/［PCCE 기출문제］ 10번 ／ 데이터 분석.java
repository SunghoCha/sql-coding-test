import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        /*
            ext : code date maximum remain
            < val_ext
            sort_by (타이브레이커 없어도 됨)
            ext를 받아서 0,1,2,3으로 변환?
            그걸로 data[i][0,1,2,3] < val_ext?
        */
        
        int idx = getType(ext);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i][idx] >= val_ext) {
                continue;
            }
            list.add(data[i]);
        }
        int sortIdx = getType(sort_by);
        Collections.sort(list, (a, b) -> {
            return a[sortIdx] - b[sortIdx];
        });
        int[][] ans = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
            
        return ans;
    }
    
    public static int getType(String ext) {
        int idx = 0;
        if (ext.equals("code")) {
            idx = 0;
        } else if (ext.equals("date")) {
            idx = 1;
        } else if (ext.equals("maximum")) {
            idx = 2;
        } else { // remain
            idx = 3;
        }    
        return idx;
    }
    
}
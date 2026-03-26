import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        /*
            들은 멜로디는 원곡의 순서가 바뀐 케이스일 수 있다.
            들은 멜로디는 원곡 일부분 + 다른 곡 일부분일 수 있다. -> 이게 잘못이해한건가?
            "반대로, 한 음악을 중간에 끊을 경우 원본 음악에는 네오가 
            기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다."
            오개념인듯? 해당 부분이 여러곡에서 등장할수있다는 뜻인듯?
            재생시간이 길만 반복. 짧으면 거기까지.
            조건 일치 음악 여러개면 재생된 시간이 제일 긴 음악 제목 반환
            재생된 시간도 같을 경우 먼저 입력된 음악 제목 반환.
            "재생된 시간", "입력된 순서"로 비교해야함. 객체로 만들어야하나?
            [시작시각 끝난시각 음악제목 악보정보]
            원곡순서만 바뀐거면 원형배열처럼 찾을텐데..
            일단 원형배열로 찾다가 어긋나면 다른 곡의 시작부분인지 찾나?
            그냥 원형배열도아님 그냥 주어진시간만큼 배열만들어내면 될 듯
            
            그리고 #이 중요. 3번쨰 예시를 보면 ABC가 있지만 다음이 #이라서
            ABC#가 됨. C가 아니라 C#인거라서 답이 아닌 케이스..
            C#은 하나의 음으로 판단해야하니까
            문자열에서 Character로 접근하는게 아닌듯?
            String으로 접근?
            
            리뷰받음
            문자열치환을 떠올리지 못했음. #때문에 현재위치 뒤쪽까지 매번확인하도록 이상하게 구현할뻔함
            
            
            
        */
        String target = convert(m);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Music> pri = new PriorityQueue<>(); 
        List<Music> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            sb = new StringBuilder();
            String str = musicinfos[i];
            String[] split = str.split(",");
            int time = convertTime(split[1]) - convertTime(split[0]);
            String name = split[2];
            String music = convert(split[3]);
                            
            for (int j = 0; j < time / music.length(); j++) {
                sb.append(music);
            }
            sb.append(music.substring(0, time % music.length()));
            
            music = sb.toString();
            list.add(new Music(name, i, music, time));                        
        }
        for (Music music : list) {
           if (music.info.contains(target)) {
               pri.offer(music);
           } 
        }
        if (pri.isEmpty()) {
            return "(None)";
        } else {
            return pri.poll().name;    
        }
        
       
    }
    
    public String convert(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            char ch = chars[i];
            if (chars[i + 1] == '#') {
                sb.append(String.valueOf(ch).toLowerCase()); // 소문자로 치환
                i++;
            } else {
                sb.append(ch); // 대문자
            }
        }
        if (chars[n - 1] != '#') {
            sb.append(chars[n - 1]); // 마지막이 #이 아니라면 따로 추가
        }
        return sb.toString();
    }
  
    public int convertTime(String timeStr) {
        String[] split = timeStr.split(":");
        
        return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
    }
   
    
    public static class Music implements Comparable<Music> {
        String name;
        int order;
        String info;
        int time;
        
        Music(String n, int o, String i, int t) {
            this.name = n;
            this.order = o;
            this.info = i;
            this.time = t;
        }
        
        @Override
        public int compareTo(Music other) {
            if (this.time == other.time) {
                return this.order - other.order; // 순서 오름차순
            } 
            return other.time - this.time; // 시간 내림차순
            
        }
    }
}
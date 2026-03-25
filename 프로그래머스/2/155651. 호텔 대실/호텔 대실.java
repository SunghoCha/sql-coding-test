import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        /*
            대실타임비교
            예약순서가 중요할까? 상관없는거아닌가? 굳이 정렬안해도?
            안한다고 치고 생각해보자
            *시간시뮬레이션이 필요한가?
            일단 그냥해보자
            자료구조선택은? 근데 항상 여기서 막히는게
            다른 것들하교 다 비교해야한다고 생각하고 무조건 배열에 완탐을 떠올리는 멍청한 선택만함
            
            리뷰받음
            현재 데이터에서 다른 모든 데이터들이 비교대상이 아님
            현재 데이터 기준 이미 지난 과거는 상관없음
            과거는 어떤 기준? 종료시간 기준일듯
            현재 데이터의 시작시간과 종료시간이 필요, 현재의 시작과 있는것들의 종료시간
            종료시간이 가장 빠른 것과 비교해서 가능한지체크?
            우선순위큐? 민힙?
            여기서 당장 추가가 안되면 어떻게 처리한다는거지? 별도의 우선순위큐 하나 더 만들기?
            
            다시리뷰받음
            병신같이 우선순위큐 = 방 이라는 멍청한 생각을 해버림
            우선순위큐의 사이즈가 방의 개수라는 생각을 전혀 하지못함. 왜 하지못했을까?
            멍청하게 우선순위큐에는 시간의 흐름에 따라 모든 예약들이 다 들어있을거라고 생각함
            우선순위큐에 저장될떄는 끝나는 시간만 필요한가?
            시작시간은 배정시에만 필요? 정렬때도 필요없나?
            왜 이런게 정리가 안되는거지?
            
            심지어 정렬도 시작시간이 아니라 종료시간 기준으로 아무 생각없이함
        */
        List<Book> list = new ArrayList<>();
        for (String[] strArr: book_time) {
            
            int start = convertTime(strArr[0]);
            int end = convertTime(strArr[1]);
           
            list.add(new Book(start, end + 10));
            
        }
        // 종료시간 오름차순
        list.sort((a, b) -> {
            return a.start - b.start;
        });
        PriorityQueue<Book> minHeap = new PriorityQueue<>((a, b) -> {
            return a.end - b.end;
        });
        for (Book book : list) {
            // 새로 그 방이 채워질때만 꺼내짐
            if (!minHeap.isEmpty() && minHeap.peek().end <= book.start) { 
                minHeap.poll(); // 기존 끝난것 꺼냄
                minHeap.offer(book);
            } else { // 힙이 비었거나 기다려야하는 상태라면 힙에 그냥 추가
                minHeap.offer(book);    
            }
        }
        
        return minHeap.size();
    }
    
    public int convertTime(String str) {
        String[] split = str.split(":");
        int hh = Integer.parseInt(split[0]);
        int mm = Integer.parseInt(split[1]);
        return hh * 60 + mm;
    }
    

    
    public static class Book {
        int start;
        int end;
        
        Book(int s, int e) {
            this.start = s;
            this.end = e;
        }

    }
}
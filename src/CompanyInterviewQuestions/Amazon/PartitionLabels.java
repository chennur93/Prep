package CompanyInterviewQuestions.Amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        int[] end = new int[26];

        for(int i=0;i<S.length();i++){
            end[S.charAt(i)-'a'] = i;
        }

        int counter = 0;


        List<Integer> res = new ArrayList<Integer>();
        while(counter < S.length()){

            int start = counter;
            int max = counter;
            while(counter <= max){
                max = Math.max(max,end[S.charAt(counter)-'a']);
                counter++;
            }

            res.add(max - start+1);


        }

        return res;

    }
}

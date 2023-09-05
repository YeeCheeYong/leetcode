package Package;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private HashMap<String, String> dictionary2;
    private String file;

    public SaveableDictionary() {
        dictionary = new HashMap<>();
        dictionary2 = new HashMap<>();
    }

    public void add(String words, String translation) {
        dictionary.putIfAbsent(words, translation);//to eng
        dictionary2.putIfAbsent(translation, words);//fr eng
    }

    public String translate(String word) {
        String ans = dictionary.getOrDefault(word, null);
        if (ans == null)
            ans = dictionary2.putIfAbsent(word, null);
        return ans;
    }

    public void delete(String word) {
        if (dictionary.containsKey(word)) {
            String val = dictionary2.get(word);
            dictionary2.remove(val);
            dictionary.remove(word);
        }
        if (dictionary2.containsKey(word)) {
            String val = dictionary.get(word);
            dictionary.remove(val);
            dictionary2.remove(word);
        }
    }

    public SaveableDictionary(String file) {
        dictionary = new HashMap<>();
        dictionary2 = new HashMap<>();
        this.file = file;
    }

    public boolean load() {
        ArrayList<String> rows = new ArrayList<>();
        try {
            Files.lines(Paths.get("file.txt"))
                    .forEach(x -> rows.add(x));
            for (String x : rows) {
                String[] parts = x.split(":");
                add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (String key : dictionary.keySet())
                writer.println(printToDic(key));
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }
    }

    public String printToDic(String key) {
        return key + ": " + dictionary.get(key);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
int a[][]={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int b[] = {4, 8};
        int c[][]={{3,4},{6,7}};
        int d[]={1,2};
        int e[][]=new int[3][2];
        e=insert(a,b);
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++) {
                System.out.print("new "+e[i][j]);
            }
            System.out.println();
        }

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]>b=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(newInterval[1]<intervals[i][0])
            {
                b.add(newInterval);
                for(int j=i;j<intervals.length;j++)
                {
                    b.add(intervals[j]);

                }
                break;
            }

            if(newInterval[0]>intervals[i][1])
            {
               // for(int j=i;j<intervals.length;j++)
                //{
                    b.add(intervals[i]);
                    //break;
                continue;
                //}
                //b.add(newInterval);
                //break;
            }
           // if(newInterval[0]>intervals[i][1])
            if(newInterval[0]>=intervals[i][0]&&
                    newInterval[0]<=intervals[i][1])
            {
                newInterval[0]=intervals[i][0];
                //break;

                //else keep my end

            }
            if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1])
            {
                newInterval[1]=intervals[i][1];
                //break;
            }
            //if(newInterval[1]>=intervals[i][0])


        }
        boolean x=false;
        for(int i=0;i<b.size();i++)
        {
            if(b.get(i).equals(newInterval))
            {
                x=true;break;
            }
        }
        if(x==false)b.add(newInterval);
        for(int i=0;i<b.size();i++)
        {
            System.out.println("b "+b.get(i));
        }

        int z[][]=b.toArray(new int[b.size()][2]);
        return z;

    }

}

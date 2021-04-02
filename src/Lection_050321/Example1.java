package Lection_050321;

public class Example1 {


    int convertBall(int ball){
        int result=0;
        if(ball<=60){
            result=2;
        }else if(ball<75){
            result=3;
        }else if(ball<=90){
            result=4;
        }else{
            result=5;
        }

//аналіз граничних значень  59;60;61;74;75;76;89;90;91
        // розбиття вхідних даних на класи еквівалентності  35; 65; 80;95
        return result;
    }
    
    
    int[]   deleteElement(int[] arr, int index){
        int[]  result=new int[arr.length-1];
        for (int i = 0; i < arr.length ; i++) {
            while(i==index){
                result[i]=arr[i];
                continue;
            }

        }
        return result;
    }
}

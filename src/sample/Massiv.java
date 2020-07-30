package sample;

public class Massiv {
    public Double[][] v=new Double[5][5];
    public Massiv(){
        Fill();
    }
    public void Fill(){
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                v[i][j]=Math.random()*100-50;
    }
}

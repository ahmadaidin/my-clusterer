/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlClustering;

import weka.clusterers.AbstractClusterer;
import weka.clusterers.ClusterEvaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author toshiba
 */
public class MLClustering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        DataSource source = new DataSource("data.csv");
        MyKMeans kmeans = new MyKMeans(4);
        Instances datas = source.getDataSet();
        int[] result = new int[100];
        //System.out.println("* " + datas.size());
        //System.out.println(datas.a);
        //kmeans.buildClusterer(datas);
        //agnes.buildClusterer(datas);
        //System.out.println(kmeans.getAllClusters()[0].toString());
        
        //System.out.println(datas.toSummaryString());
        //kmeans.printResult();

//        System.out.println(s);
        NumberFormat df = new DecimalFormat("#0.00");
        for(int i = 2; i < 10; i++) {
            AgnesCluster agnes = new AgnesCluster(1);
            agnes.setNumCluster(i);
            agnes.buildClusterer(datas);
            for(int j = 0; j < i; j++) {
                result[j] = 0;
            }
            for(int j = 0; j < datas.size(); j++) {
                int clus = agnes.clusterInstance(datas.get(j));
                int a = result[clus];
                result[clus] = a+1;
            }

            System.out.println("Jumlah kluster = " + i);
            for(int j = 0; j < i; j++) {

                System.out.println(j + "    " + result[j] + "(" + df.format((double)result[j]/(double)datas.size() * 100)+"%)");

            }
            System.out.println("");
        }
        //ClusterTree<Instance> tes = agnes.getClusterTree();
        //tes.print("");
        //ClusterEvaluation eval = new ClusterEvaluation();
        //eval.setClusterer(kmeans);
        //eval.evaluateClusterer(datas);
        //System.out.println(eval.clusterResultsToString());
    }
    
}

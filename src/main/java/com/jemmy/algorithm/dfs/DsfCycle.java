package com.jemmy.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiang.cheng
 * @since 2020/4/27
 */
public class DsfCycle {

    private static int MAX_NODE_COUNT = 100;

    private static List<String> nodes = new ArrayList<>();

    private static int[][] adjacencyMatrix = new int[MAX_NODE_COUNT][MAX_NODE_COUNT];

    private static int addNode(String nodeName) {
        if (!nodes.contains(nodeName)) {
            if (nodes.size() >= MAX_NODE_COUNT) {
                System.out.println("nodes超长: " + nodeName);
                return -1;
            }
            nodes.add(nodeName);
            return nodes.size() - 1;
        }
        return nodes.indexOf(nodeName);
    }

    public static void addLine(String startNode, String endNode) {
        int startIndex = addNode(startNode);
        int endIndex = addNode(endNode);
        if (startIndex >= 0 && endIndex >= 0) {
            adjacencyMatrix[startIndex][endIndex] = 1;
        }
    }

    public static List<String> find() {
        List<Integer> trace = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (adjacencyMatrix.length > 0) {
            findCycle(0, trace, result);
        }
        if (result.size() == 0) {
            result.add("no cycle!");
        }
        return result;
    }

    private static void findCycle(int v, List<Integer> trace, List<String> result) {
        int j;
        if ((j = trace.indexOf(v)) != -1) {
            StringBuilder builder = new StringBuilder();
            String startNode = nodes.get(trace.get(j));
            while (j < trace.size()) {
                builder.append(nodes.get(trace.get(j)) + '-');
                j++;
            }
            result.add("cycle:" + builder.toString() + startNode);
            return;
        }
        trace.add(v);
        for (int i = 0; i < nodes.size(); i++) {
            if (adjacencyMatrix[v][i] == 1) {
                findCycle(i, trace, result);
            }
        }
        trace.remove(trace.size() - 1);
    }

    public static void main(String[] args) {
        DsfCycle.addLine("A", "B");
        DsfCycle.addLine("A", "C");
        DsfCycle.addLine("B", "D");
        DsfCycle.addLine("D", "A");
        List<String> result = DsfCycle.find();
        for (String string : result) {
            System.out.println(string);
        }
    }

}

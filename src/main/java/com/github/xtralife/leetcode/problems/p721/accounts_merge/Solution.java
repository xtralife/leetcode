package com.github.xtralife.leetcode.problems.p721.accounts_merge;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Node> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            Node firstNode = getOrCreate(account.get(1), graph, name);
            for (int i = 2; i < account.size(); i++) {
                Node node = getOrCreate(account.get(i), graph, name);
                node.neighbors.add(firstNode);
                firstNode.neighbors.add(node);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String email : graph.keySet()) {
            Node node = graph.get(email);
            if (node.visited) {
                continue;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            List<String> account = new ArrayList<>();
            account.add(node.name);
            Set<String> emails = new TreeSet<>();
            while (!queue.isEmpty()) {
                Node next = queue.poll();
                emails.add(next.email);
                next.visited = true;
                for (Node neighbor : next.neighbors) {
                    if (!neighbor.visited) {
                        queue.add(neighbor);
                    }
                }
            }
            account.addAll(emails);
            result.add(account);
        }

        return result;
    }

    private Node getOrCreate(String email, Map<String, Node> graph, String name) {
        if (graph.containsKey(email)) {
            return graph.get(email);
        }
        Node node = new Node();
        node.email = email;
        node.name = name;
        node.neighbors = new HashSet<>();
        graph.put(email, node);
        return node;
    }
}

class Node {
    String email;
    String name;
    Set<Node> neighbors;
    boolean visited = false;
}

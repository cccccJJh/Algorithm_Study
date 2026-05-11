
public void dfs(String now, String path, String[][] tickets, int count, boolean[] visited) {
    if (count == 0) {
        allPath.add(now);
    }
    if (count == tickets.length) {
        //allPaths.add(path);
        return;
    }

    for (int i = 0; i < tickets.length; i++) {
        if (!visited[i]) {
            if (tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(tickets[i][1], path + "," + tickets[i][1], tickets, count + 1, visited);
            }
        }
    }

}
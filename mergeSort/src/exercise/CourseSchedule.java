package exercise;

public class CourseSchedule {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        Node[] graph = new Node[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new Node(i);
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].neighbours.add(prerequisites[i][0]);
            graph[prerequisites[i][0]].inCount++;
        }
        
        //find start node
        Deque<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(graph[i].inCount == 0) {
                queue.addLast(graph[i]);
            }
        }
        
        if(queue.size() == 0) {
            return new int[0];
        }
        
        int i = 0;
        int visitedNode = 0;
        while(queue.size() > 0) {
            Node node = queue.removeFirst();
            if(visited[node.numOfCourse]) {
                return new int[0];
            }
            visited[node.numOfCourse] = true;
            visitedNode++;
            result[i] = node.numOfCourse;
            for(int j = 0; j < node.neighbours.size(); j++) {
                graph[node.neighbours.get(j)].inCount--;
                if(graph[node.neighbours.get(j)].inCount == 0) {
                    queue.addLast(graph[node.neighbours.get(j)]);
                }
                
            }
            i++;
        }
        
        if(visitedNode != visited.length ) return new int[0];
        return result;
        
    }
    
    class Node {
        int inCount;
        int numOfCourse;
        ArrayList<Integer> neighbours;
        
        public Node (int numOfCourse) {
            inCount = 0;
            neighbours = new ArrayList<Integer>();
            this.numOfCourse = numOfCourse;
        }
    }
}

package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String tasksOwner){
        switch (tasksOwner.toLowerCase()){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid task owner. Use 'ann', 'bob', 'carol', or 'all'.");
        }
    }

    public Set<Task> getUnion(Set<Task>...taskSets){
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> taskSet : taskSets){
            unionSet.addAll(taskSet);
        }
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> taskSet1, Set<Task> taskSet2){
        Set<Task> intersectSet = new HashSet<>(taskSet1);
        intersectSet.retainAll(taskSet2);
        return intersectSet;
    }

    public Set<Task> getDifferences(Set<Task> taskSet1, Set<Task> taskSet2){
        Set<Task> differenceSet = new HashSet<>(taskSet1);
        differenceSet.removeAll(taskSet2);
        return differenceSet;
    }
}

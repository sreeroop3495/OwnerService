package com.project.continental.OwnerService.Model;

public class ViolationRecord {

    /**
     * This class is used to get the violation report from police cop service
     */

    int id;
    String regno;
    String section;
    int count;

    public ViolationRecord(int id, String regno, String section, int count) {
        this.id = id;
        this.regno = regno;
        this.section = section;
        this.count = count;
    }
    public ViolationRecord(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ViolationRecord{" +
                "id=" + id +
                ", regno='" + regno + '\'' +
                ", section='" + section + '\'' +
                ", count=" + count +
                '}';
    }
}

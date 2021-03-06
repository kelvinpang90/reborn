package com.reborn.test.design_pattern.composite;

public class HRDepartment extends Company {
    public HRDepartment(String name) {
        super(name);
    }

    @Override
    protected void addSubCompany(Company company) {
        //do something
    }

    @Override
    protected void removeSubCompany(Company company) {
        //do something
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<depth;i++){
            sb.append("-");
        }
        System.out.println(sb.toString()+super.getName());
    }
}

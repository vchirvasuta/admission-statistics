package com.vali.admission_statistics.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vali.admission_statistics.service.StudentService;

@Route
public class MainView extends VerticalLayout {

    private final Button importStudentsBtn;

    private StudentService studentService;

    public MainView(StudentService studentService) {

        this.importStudentsBtn = new Button("Import Students", VaadinIcon.INSERT.create());

        HorizontalLayout actions = new HorizontalLayout(importStudentsBtn);
        add(actions);

        importStudentsBtn.addClickListener(e -> studentService.loadStudents());

    }
}

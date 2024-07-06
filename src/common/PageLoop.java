package common;

import java.util.Scanner;

public class PageLoop {
   final AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }
    public void run(){
        while (true){ // (true) - ����� ��������� �� ������ �� ���������� ������� ��� ������ ������ � ���� �������� � ����� �����
            // � ����� ����� ��������� ������ ������ ��������� � ��������� new MainView(mainChildren) �� �������� AppView -
            // AppView mainView = new MainView(mainChildren);
            // �� ���������� � ����������� � ��������� ����� run()
            // new PageLoop(mainView).run();
            // � ���� ������ ���������/������� true ����� ����������� �� ������
            // break; // ����� �� �������, ������� �������� � ���� ���� - ����������
            // ������ ����� ������ � ������������ � ���� ���������, ��������� ��������� ��������� ��������� ��� �������� true.
            // ������ � �������� -> ���������� � ������ ������, ������� ������������ �����������, �� ��������� ������ � ��� �����
            // ��������� ��������� �� ������� � �������, ������ ��� ������� �� ���������� ������ � ��������, ����������� ������.
            // ������� break; // ����� �� �������, ������� �������� � ���� ���� - ����������, ��� ��������� �������� �� ���������� �������
            // ������������ ����� �� ���� �� ��������� �� ������� ������ �� ���������� ����������� ������� � ��������� �
            // new PageLoop(mainView).run();
            view.action();
            displayChildren();
            Scanner scanner = new Scanner(System.in);
            int value = scanner.nextInt();
            if(value < 0 || value == 0 || value > view.children.size()+1){ // �������� ������� - value == 0
                System.out.println("�������� �������� ��������");
            } else if(value == view.children.size()+1){
                break; // ����� �� �������, ������� �������� � ���� ���� - ����������
            } else {
                AppView selectedView = view.children.get(value-1);
                new PageLoop(selectedView).run();
            }
        }
    }
    void displayChildren(){
        System.out.println(view.title);
        System.out.println("�������� ������� (�� 1 �� "+ (view.children.size()+1) +")");
        for (int i = 0; i < view.children.size(); i++) {
            AppView _view = view.children.get(i);
            System.out.println(i+1 +" - "+ _view.title);
        }
        System.out.println(view.children.size()+1 + " �����"); // // ����� �� �������, ������� �������� � ���� ���� - ����������
    }
}

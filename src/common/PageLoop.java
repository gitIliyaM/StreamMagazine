package common;

import java.util.Scanner;

public class PageLoop {
   final AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }
    public void run(){
        while (true){ // (true) - будет выполнять до выхода из последнего объекта или первый объект и цикл передали в точке входа
            // В точке входа создается первый объект наследник с массивами new MainView(mainChildren) от родителя AppView -
            // AppView mainView = new MainView(mainChildren);
            // он передается в конструктор и запускает метод run()
            // new PageLoop(mainView).run();
            // в этом методе выражение/условие true будет выполняться до выхода
            // break; // выход из объекта, который передали в этот цикл - прерывание
            // Каждый новый массив с добавленными в него объектами, позволяет создавать вложенную структуру для проверки true.
            // Объект с массивом -> передается с другой объект, который используется конструктор, он сохраняет массив и так далее
            // Вложенная структура из массива и объекта, каждый раз попадая во внутренний объект с массивом, погружаемся внутрь.
            // поэтому break; // выход из объекта, который передали в этот цикл - прерывание, оно позволяет выходить из выбранного объекта
            // возвращаться назад на верх по структуре до полного выхода из последнего переданного объекта с массивами в
            // new PageLoop(mainView).run();
            view.action();
            displayChildren();
            Scanner scanner = new Scanner(System.in);
            int value = scanner.nextInt();
            if(value < 0 || value == 0 || value > view.children.size()+1){ // дополнил условие - value == 0
                System.out.println("Неверное значение страницы");
            } else if(value == view.children.size()+1){
                break; // выход из объекта, который передали в этот цикл - прерывание
            } else {
                AppView selectedView = view.children.get(value-1);
                new PageLoop(selectedView).run();
            }
        }
    }
    void displayChildren(){
        System.out.println(view.title);
        System.out.println("Выберите вариант (от 1 до "+ (view.children.size()+1) +")");
        for (int i = 0; i < view.children.size(); i++) {
            AppView _view = view.children.get(i);
            System.out.println(i+1 +" - "+ _view.title);
        }
        System.out.println(view.children.size()+1 + " назад"); // // выход из объекта, который передали в этот цикл - прерывание
    }
}

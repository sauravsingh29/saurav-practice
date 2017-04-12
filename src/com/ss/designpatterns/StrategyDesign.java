package com.ss.designpatterns;

interface Operation {
    public double doOperation();
}

/**
 * Created by Saurav on 11-04-2017.
 */
public class StrategyDesign {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new AddOperation(3.4, 3.6));
        System.out.println("Addition Strategy Execution ::\t" + context.executeOperation());

        context = new StrategyContext(new SubtractOperation(10.5, 0.5));
        System.out.println("Subtraction Strategy Execution ::\t" + context.executeOperation());
    }


}

class StrategyContext {
    private Operation operation;

    public StrategyContext(Operation operation) {
        this.operation = operation;
    }

    public double executeOperation(){
        return operation.doOperation();
    }
}

class AddOperation implements Operation {
    private double first;
    private double sec;

    public AddOperation(double first, double sec) {
        this.first = first;
        this.sec = sec;
    }

    @Override
    public double doOperation() {
        return first + sec;
    }
}


class SubtractOperation implements Operation {
    private double first;
    private double sec;

    public SubtractOperation(double first, double sec) {
        this.first = first;
        this.sec = sec;
    }

    @Override
    public double doOperation() {
        return first - sec;
    }
}

class MultiPlyOperation implements Operation {
    private double first;
    private double sec;

    public MultiPlyOperation(double first, double sec) {
        this.first = first;
        this.sec = sec;
    }

    @Override
    public double doOperation() {
        return first * sec;
    }
}


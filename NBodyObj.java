/**
* Name: Yuvaraj Gambhir
* Pennkey: 12279760
* Execution: java NBodyObj cmd-line 0, cmd-line 1, cmd-line 2
*
* Description: brings everything together!
**/
public class NBodyObj {
    public static void main(String[] args) {
        //command-line arg variables
        double simulationTime = Double.parseDouble(args[0]);
        double timeStep = Double.parseDouble(args[1]);
        String filename = args[2];
        
        //creates an instance of the space class
        Space myUniverse = new Space(filename);
        
        double elapsedTime = 0;
        PennDraw.enableAnimation(30);
        
        //time loop
        while (elapsedTime < simulationTime) {
            myUniverse.simulate(timeStep);
            myUniverse.draw();
            elapsedTime += timeStep;
            PennDraw.advance();
        }
        PennDraw.disableAnimation();
        
        System.out.println(myUniverse);
        
    }
}

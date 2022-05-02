/**
* Name: Yuvaraj Gambhir
* Pennkey: 12279760
* Execution: n/a space constructor
*
* Description: Creates the body class and includes the constructor
* for the body object that is used throughout the assignment.
**/
public class Space {
    
    public static void main(String[] args) {
        Space s = new Space("solarSystem.txt");
        s.draw();
    }
    
    /**
    * DO NOT EDIT ANY CODE BELOW THIS LINE
    *
    * You will get a style warning that reads:
    * "Variable '[some name]' must be private and have get/set methods."
    * Ignore any style warnings of this form. Our tests rely on these
    * variables being public. We will discuss public vs. private next week
    * in class. You are not expected to know it now.
    */
    public Body[] bodies; //array of Body objects in the space
    public double radius; //radius of the universe
    
    /* DO NOT EDIT ANY CODE ABOVE THIS LINE */
    
    /**
    * Constructor: This creates a new instance of a space object.
    */
    public Space(String filename) {
        In inStream = new In(filename);
        
        //variables to store values from file
        int numBodies = inStream.readInt();
        radius = inStream.readDouble();
        
        bodies = new Body[numBodies];
        
        //sets the scale
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        
        //populates bodies array with body objects
        for (int i = 0; i < numBodies; i++) {
            bodies[i] = new Body(inStream.readDouble(), inStream.readDouble(),
            inStream.readDouble(), inStream.readDouble(),
            inStream.readDouble(), inStream.readString());
        }
        
    }
    
    /**
    * Description: returns a string representation of space for the purposes
    * of printing. We have discussed toString methods in class.
    *
    * DO NOT EDIT THIS METHOD AT ALL!
    */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + bodies.length + "\n");
        sb.append(String.format("%.2e\n", radius) + "\n");
        for (int i = 0; i < bodies.length; i++) {
            sb.append(bodies[i].toString() + "\n");
        }
        return sb.toString();
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: nothing
    * Outputs: nothing
    * Description: draws starfield and bodies
    */
    public void draw() {
        PennDraw.picture(0.0, 0.0, "starfield.jpg");
        
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].draw();
        }
        
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: timestep
    * Outputs: nothing
    * Description: simulates the motion of the bodies
    */
    public void simulate(double timeStep) {
        for (int i = 0; i < bodies.length; i++) {
            for (int j = 0; j < bodies.length; j++)
            if (j != i) {
                bodies[i].getAffectedBy(bodies[j], timeStep);
            }
            
        }
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].move(timeStep);
        }
        
    }
}

/**
* Name: Yuvaraj Gambhir
* Pennkey: 12279760
* Execution: n/a body constructor
*
* Description: Creates the body class and includes the constructor
* for the body object that is used throughout the assignment.
**/
public class Body {
    
    /**
    * DO NOT EDIT ANY CODE BELOW THIS LINE
    *
    * You will get a style warning that reads:
    * "Variable '[some name]' must be private and have get/set methods."
    * Ignore any style warnings of this form. Our tests rely on these
    * variables being public. We will discuss public vs. private next week
    * in class. You are not expected to know it now.
    */
    public double px, py; //position
    public double vx, vy; //velocity
    public double m; //mass
    public String img; //image file
    
    public static final double G = 6.67e-11; //gravity constant
    
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/
    
    /**
    * Constructor: This creates a new instance of a body object.
    */
    public Body(double mass, double posX, double posY,
    double velX, double velY, String imageFile) {
        m = mass;
        px = posX;
        py = posY;
        vx = velX;
        vy = velY;
        img = imageFile;
        
    }
    
    /**
    * Description: returns a string representation of the body for the
    * purposes of printing. We will discuss toString methods in class.
    *
    * DO NOT EDIT THIS METHOD AT ALL!
    */
    public String toString() {
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s",
        m, px, py, vx, vy, img);
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: takes in a Body object
    * Outputs: a double of the distance
    * value between two bodies in the x direction
    * Description: computes a double of the distance
    * value between two bodies in the x direction
    */
    public double distanceToX(Body other) {
        return other.px - this.px;
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: takes in a Body object
    * Outputs: a double of the distance
    * value between two bodies in the y direction
    * Description: computes a double of the distance
    * value between two bodies in the y direction
    */
    public double distanceToY(Body other) {
        return other.py - this.py; // dummy return
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: a Body object
    * Outputs: the distance as a double
    * Description: find the distance between two bodies
    * factoring in the x and y components
    */
    public double distanceTo(Body other) {
        //TODO: Implement this method
        return Math.sqrt((this.distanceToX(other) *
        this.distanceToX(other)) + (this.distanceToY(other) *
        this.distanceToY(other)));
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: Body object
    * Outputs: force
    * Description: force between two bodies
    */
    public double force(Body other) {
        return G * this.m * other.m / (this.distanceTo(other) *
        this.distanceTo(other));
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: body object
    * Outputs: force in x direction
    * Description: force btw two bodies in x direction
    */
    public double forceX(Body other) {
        return (this.force(other) * this.distanceToX(other)) /
        this.distanceTo(other);
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: Body object
    * Outputs: force in y component
    * Description: force in y component btw two bodies
    */
    public double forceY(Body other) {
        //TODO: Implement this method
        return (this.force(other) * this.distanceToY(other)) /
        this.distanceTo(other);
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: nothing
    * Outputs: nothing
    * Description: draws the bodies
    */
    public void draw() {
        PennDraw.picture(this.px, this.py, this.img);
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: timestep
    * Outputs: nothing
    * Description: updates position of body
    */
    public void move(double timeStep) {
        this.px += timeStep * this.vx;
        this.py += timeStep * this.vy;
    }
    
    // TODO: Add a method header comment
    /**
    * Inputs: body object, timestep
    * Outputs: nothing
    * Description: calculates acceleration and updates
    * velocity
    */
    public void getAffectedBy(Body other, double timeStep) {
        double ax = this.forceX(other) / this.m;
        double ay = this.forceY(other) / this.m;
        
        this.vx += timeStep * ax;
        this.vy += timeStep * ay;
    }
}

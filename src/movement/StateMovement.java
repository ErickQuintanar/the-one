package movement;

import core.Coord;
import core.Settings;
import core.SimClock;
import core.SimScenario;
import java.util.Random;

/**
 * Example of time-variant behavior. Random waypoint, but picks the waypoints
 * from different regions based on the current simulation time.
 *
 * @author teemuk
 */
public class StateMovement
extends MovementModel {

  //==========================================================================//
  // Instance vars
  //==========================================================================//
  private Coord location;
  private int state = 121; // E1
  // We use different random generators so that the distributions don't get mixed
  // We want discrete uniform distributions for all of them
  private Random roomRandom = new Random();
  private Random stateRandom = new Random();
  private Random locationNoise = new Random();
  //==========================================================================//



  //==========================================================================//
  // Implementation
  //==========================================================================//
  @Override
  public int getState(){
    return this.state;
  }


  @Override
  public Coord getInitialLocation() {
    //Location at the first exit
    this.location = new Coord(670,830);
    return this.location;
  }

  @Override
  public Path getPath() {
    // Creates a new path from the previous waypoint to a new one.
    final Path p;
    p = new Path( super.generateSpeed() );
    p.addWaypoint( this.location.clone() );

    // Add only one point. An arbitrary number of Coords could be added to
    // the path here and the simulator will follow the full path before
    // asking for the next one.

    // Get the simulation time
    final double curTime = SimClock.getTime();
    if( ((int) curTime) % 5400 == 0) {
      final Coord c = this.getNewState();
      p.addWaypoint(c);
      this.location = c;
    }
    return p;
  }

  protected Coord getNewState() {
    int roomType = stateRandom.nextInt(100); // Uniform distribution, ranges represent probability
    if(roomType < 60){
      this.state = 120; // RX
        setState(this.state);
      return findRoom();
    }else if(roomType < 70){
      this.state = 123; // HS1
        setState(this.state);
      return new Coord(575 + locationNoise.nextInt(150) - 75,925 + locationNoise.nextInt(150) - 75);
    }else if(roomType < 75){
      this.state = 124; // HS2
        setState(this.state);
      return new Coord(315 + locationNoise.nextInt(70) - 35,730 + locationNoise.nextInt(70) - 35);
    }else if(roomType < 80){
      this.state = 125; // HS3
        setState(this.state);
      return new Coord(315 + locationNoise.nextInt(70) - 35,545 + locationNoise.nextInt(70) - 35);
    }else{
      this.state = 122; // Magistrale
        setState(this.state);
      return new Coord(500 + locationNoise.nextInt(300) - 150,450 + locationNoise.nextInt(800) - 400);
    }
  }

  protected Coord findRoom() {
    int roomNumber = roomRandom.nextInt(120) + 1;
    switch (roomNumber) {
      case 1:
        return new Coord(185 + locationNoise.nextInt(30) - 15,805 + locationNoise.nextInt(30) - 15);
      case 2:
        return new Coord(215 + locationNoise.nextInt(30) - 15,805 + locationNoise.nextInt(30) - 15);
      case 3:
        return new Coord(245 + locationNoise.nextInt(30) - 15,805 + locationNoise.nextInt(30) - 15);
      case 4:
        return new Coord(275 + locationNoise.nextInt(30) - 15,805 + locationNoise.nextInt(30) - 15);
      case 5:
        return new Coord(305 + locationNoise.nextInt(30) - 15,805 + locationNoise.nextInt(30) - 15);
      case 6:
        return new Coord(335 + locationNoise.nextInt(30) - 15,805 + locationNoise.nextInt(30) - 15);
      case 7:
        return new Coord(185 + locationNoise.nextInt(30) - 15,835 + locationNoise.nextInt(30) - 15);
      case 8:
        return new Coord(215 + locationNoise.nextInt(30) - 15,835 + locationNoise.nextInt(30) - 15);
      case 9:
        return new Coord(245 + locationNoise.nextInt(30) - 15,835 + locationNoise.nextInt(30) - 15);
      case 10:
        return new Coord(275 + locationNoise.nextInt(30) - 15,835 + locationNoise.nextInt(30) - 15);
      case 11:
        return new Coord(305 + locationNoise.nextInt(30) - 15,835 + locationNoise.nextInt(30) - 15);
      case 12:
        return new Coord(335 + locationNoise.nextInt(30) - 15,835 + locationNoise.nextInt(30) - 15);
      case 13:
        return new Coord(665 + locationNoise.nextInt(30) - 15,745 + locationNoise.nextInt(30) - 15);
      case 14:
        return new Coord(695 + locationNoise.nextInt(30) - 15,745 + locationNoise.nextInt(30) - 15);
      case 15:
        return new Coord(725 + locationNoise.nextInt(30) - 15,745 + locationNoise.nextInt(30) - 15);
      case 16:
        return new Coord(755 + locationNoise.nextInt(30) - 15,745 + locationNoise.nextInt(30) - 15);
      case 17:
        return new Coord(785 + locationNoise.nextInt(30) - 15,745 + locationNoise.nextInt(30) - 15);
      case 18:
        return new Coord(815 + locationNoise.nextInt(30) - 15,745 + locationNoise.nextInt(30) - 15);
      case 19:
        return new Coord(665 + locationNoise.nextInt(30) - 15,775 + locationNoise.nextInt(30) - 15);
      case 20:
        return new Coord(695 + locationNoise.nextInt(30) - 15,775 + locationNoise.nextInt(30) - 15);
      case 21:
        return new Coord(725 + locationNoise.nextInt(30) - 15,775 + locationNoise.nextInt(30) - 15);
      case 22:
        return new Coord(755 + locationNoise.nextInt(30) - 15,775 + locationNoise.nextInt(30) - 15);
      case 23:
        return new Coord(785 + locationNoise.nextInt(30) - 15,775 + locationNoise.nextInt(30) - 15);
      case 24:
        return new Coord(815 + locationNoise.nextInt(30) - 15,775 + locationNoise.nextInt(30) - 15);
      case 25:
        return new Coord(185 + locationNoise.nextInt(30) - 15,625 + locationNoise.nextInt(30) - 15);
      case 26:
        return new Coord(215 + locationNoise.nextInt(30) - 15,625 + locationNoise.nextInt(30) - 15);
      case 27:
        return new Coord(245 + locationNoise.nextInt(30) - 15,625 + locationNoise.nextInt(30) - 15);
      case 28:
        return new Coord(275 + locationNoise.nextInt(30) - 15,625 + locationNoise.nextInt(30) - 15);
      case 29:
        return new Coord(305 + locationNoise.nextInt(30) - 15,625 + locationNoise.nextInt(30) - 15);
      case 30:
        return new Coord(335 + locationNoise.nextInt(30) - 15,625 + locationNoise.nextInt(30) - 15);
      case 31:
        return new Coord(185 + locationNoise.nextInt(30) - 15,655 + locationNoise.nextInt(30) - 15);
      case 32:
        return new Coord(215 + locationNoise.nextInt(30) - 15,655 + locationNoise.nextInt(30) - 15);
      case 33:
        return new Coord(245 + locationNoise.nextInt(30) - 15,655 + locationNoise.nextInt(30) - 15);
      case 34:
        return new Coord(275 + locationNoise.nextInt(30) - 15,655 + locationNoise.nextInt(30) - 15);
      case 35:
        return new Coord(305 + locationNoise.nextInt(30) - 15,655 + locationNoise.nextInt(30) - 15);
      case 36:
        return new Coord(335 + locationNoise.nextInt(30) - 15,655 + locationNoise.nextInt(30) - 15);
      case 37:
        return new Coord(665 + locationNoise.nextInt(30) - 15,605 + locationNoise.nextInt(30) - 15);
      case 38:
        return new Coord(695 + locationNoise.nextInt(30) - 15,605 + locationNoise.nextInt(30) - 15);
      case 39:
        return new Coord(725 + locationNoise.nextInt(30) - 15,605 + locationNoise.nextInt(30) - 15);
      case 40:
        return new Coord(755 + locationNoise.nextInt(30) - 15,605 + locationNoise.nextInt(30) - 15);
      case 41:
        return new Coord(785 + locationNoise.nextInt(30) - 15,605 + locationNoise.nextInt(30) - 15);
      case 42:
        return new Coord(815 + locationNoise.nextInt(30) - 15,605 + locationNoise.nextInt(30) - 15);
      case 43:
        return new Coord(665 + locationNoise.nextInt(30) - 15,635 + locationNoise.nextInt(30) - 15);
      case 44:
        return new Coord(695 + locationNoise.nextInt(30) - 15,635 + locationNoise.nextInt(30) - 15);
      case 45:
        return new Coord(725 + locationNoise.nextInt(30) - 15,635 + locationNoise.nextInt(30) - 15);
      case 46:
        return new Coord(755 + locationNoise.nextInt(30) - 15,635 + locationNoise.nextInt(30) - 15);
      case 47:
        return new Coord(785 + locationNoise.nextInt(30) - 15,635 + locationNoise.nextInt(30) - 15);
      case 48:
        return new Coord(815 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 49:
        return new Coord(185 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 50:
        return new Coord(215 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 51:
        return new Coord(245 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 52:
        return new Coord(275 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 53:
        return new Coord(305 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 54:
        return new Coord(335 + locationNoise.nextInt(30) - 15,445 + locationNoise.nextInt(30) - 15);
      case 55:
        return new Coord(185 + locationNoise.nextInt(30) - 15,475 + locationNoise.nextInt(30) - 15);
      case 56:
        return new Coord(215 + locationNoise.nextInt(30) - 15,475 + locationNoise.nextInt(30) - 15);
      case 57:
        return new Coord(245 + locationNoise.nextInt(30) - 15,475 + locationNoise.nextInt(30) - 15);
      case 58:
        return new Coord(275 + locationNoise.nextInt(30) - 15,475 + locationNoise.nextInt(30) - 15);
      case 59:
        return new Coord(305 + locationNoise.nextInt(30) - 15,475 + locationNoise.nextInt(30) - 15);
      case 60:
        return new Coord(335 + locationNoise.nextInt(30) - 15,475 + locationNoise.nextInt(30) - 15);
      case 61:
        return new Coord(665 + locationNoise.nextInt(30) - 15,465 + locationNoise.nextInt(30) - 15);
      case 62:
        return new Coord(695 + locationNoise.nextInt(30) - 15,465 + locationNoise.nextInt(30) - 15);
      case 63:
        return new Coord(725 + locationNoise.nextInt(30) - 15,465 + locationNoise.nextInt(30) - 15);
      case 64:
        return new Coord(755 + locationNoise.nextInt(30) - 15,465 + locationNoise.nextInt(30) - 15);
      case 65:
        return new Coord(785 + locationNoise.nextInt(30) - 15,465 + locationNoise.nextInt(30) - 15);
      case 66:
        return new Coord(815 + locationNoise.nextInt(30) - 15,465 + locationNoise.nextInt(30) - 15);
      case 67:
        return new Coord(665 + locationNoise.nextInt(30) - 15,495 + locationNoise.nextInt(30) - 15);
      case 68:
        return new Coord(695 + locationNoise.nextInt(30) - 15,495 + locationNoise.nextInt(30) - 15);
      case 69:
        return new Coord(725 + locationNoise.nextInt(30) - 15,495 + locationNoise.nextInt(30) - 15);
      case 70:
        return new Coord(755 + locationNoise.nextInt(30) - 15,495 + locationNoise.nextInt(30) - 15);
      case 71:
        return new Coord(785 + locationNoise.nextInt(30) - 15,495 + locationNoise.nextInt(30) - 15);
      case 72:
        return new Coord(815 + locationNoise.nextInt(30) - 15,495 + locationNoise.nextInt(30) - 15);
      case 73:
        return new Coord(185 + locationNoise.nextInt(30) - 15,305 + locationNoise.nextInt(30) - 15);
      case 74:
        return new Coord(215 + locationNoise.nextInt(30) - 15,305 + locationNoise.nextInt(30) - 15);
      case 75:
        return new Coord(245 + locationNoise.nextInt(30) - 15,305 + locationNoise.nextInt(30) - 15);
      case 76:
        return new Coord(275 + locationNoise.nextInt(30) - 15,305 + locationNoise.nextInt(30) - 15);
      case 77:
        return new Coord(305 + locationNoise.nextInt(30) - 15,305 + locationNoise.nextInt(30) - 15);
      case 78:
        return new Coord(335 + locationNoise.nextInt(30) - 15,305 + locationNoise.nextInt(30) - 15);
      case 79:
        return new Coord(185 + locationNoise.nextInt(30) - 15,335 + locationNoise.nextInt(30) - 15);
      case 80:
        return new Coord(215 + locationNoise.nextInt(30) - 15,335 + locationNoise.nextInt(30) - 15);
      case 81:
        return new Coord(245 + locationNoise.nextInt(30) - 15,335 + locationNoise.nextInt(30) - 15);
      case 82:
        return new Coord(275 + locationNoise.nextInt(30) - 15,335 + locationNoise.nextInt(30) - 15);
      case 83:
        return new Coord(305 + locationNoise.nextInt(30) - 15,335 + locationNoise.nextInt(30) - 15);
      case 84:
        return new Coord(335 + locationNoise.nextInt(30) - 15,335 + locationNoise.nextInt(30) - 15);
      case 85:
        return new Coord(665 + locationNoise.nextInt(30) - 15,325 + locationNoise.nextInt(30) - 15);
      case 86:
        return new Coord(695 + locationNoise.nextInt(30) - 15,325 + locationNoise.nextInt(30) - 15);
      case 87:
        return new Coord(725 + locationNoise.nextInt(30) - 15,325 + locationNoise.nextInt(30) - 15);
      case 88:
        return new Coord(755 + locationNoise.nextInt(30) - 15,325 + locationNoise.nextInt(30) - 15);
      case 89:
        return new Coord(785 + locationNoise.nextInt(30) - 15,325 + locationNoise.nextInt(30) - 15);
      case 90:
        return new Coord(815 + locationNoise.nextInt(30) - 15,325 + locationNoise.nextInt(30) - 15);
      case 91:
        return new Coord(665 + locationNoise.nextInt(30) - 15,355 + locationNoise.nextInt(30) - 15);
      case 92:
        return new Coord(695 + locationNoise.nextInt(30) - 15,355 + locationNoise.nextInt(30) - 15);
      case 93:
        return new Coord(725 + locationNoise.nextInt(30) - 15,355 + locationNoise.nextInt(30) - 15);
      case 94:
        return new Coord(755 + locationNoise.nextInt(30) - 15,355 + locationNoise.nextInt(30) - 15);
      case 95:
        return new Coord(785 + locationNoise.nextInt(30) - 15,355 + locationNoise.nextInt(30) - 15);
      case 96:
        return new Coord(815 + locationNoise.nextInt(30) - 15,355 + locationNoise.nextInt(30) - 15);
      case 97:
        return new Coord(185 + locationNoise.nextInt(30) - 15,165 + locationNoise.nextInt(30) - 15);
      case 98:
        return new Coord(215 + locationNoise.nextInt(30) - 15,165 + locationNoise.nextInt(30) - 15);
      case 99:
        return new Coord(245 + locationNoise.nextInt(30) - 15,165 + locationNoise.nextInt(30) - 15);
      case 100:
        return new Coord(275 + locationNoise.nextInt(30) - 15,165 + locationNoise.nextInt(30) - 15);
      case 101:
        return new Coord(305 + locationNoise.nextInt(30) - 15,165 + locationNoise.nextInt(30) - 15);
      case 102:
        return new Coord(335 + locationNoise.nextInt(30) - 15,165 + locationNoise.nextInt(30) - 15);
      case 103:
        return new Coord(185 + locationNoise.nextInt(30) - 15,195 + locationNoise.nextInt(30) - 15);
      case 104:
        return new Coord(215 + locationNoise.nextInt(30) - 15,195 + locationNoise.nextInt(30) - 15);
      case 105:
        return new Coord(245 + locationNoise.nextInt(30) - 15,195 + locationNoise.nextInt(30) - 15);
      case 106:
        return new Coord(275 + locationNoise.nextInt(30) - 15,195 + locationNoise.nextInt(30) - 15);
      case 107:
        return new Coord(305 + locationNoise.nextInt(30) - 15,195 + locationNoise.nextInt(30) - 15);
      case 108:
        return new Coord(335 + locationNoise.nextInt(30) - 15,195 + locationNoise.nextInt(30) - 15);
      case 109:
        return new Coord(665 + locationNoise.nextInt(30) - 15,185 + locationNoise.nextInt(30) - 15);
      case 110:
        return new Coord(695 + locationNoise.nextInt(30) - 15,185 + locationNoise.nextInt(30) - 15);
      case 111:
        return new Coord(725 + locationNoise.nextInt(30) - 15,185 + locationNoise.nextInt(30) - 15);
      case 112:
        return new Coord(755 + locationNoise.nextInt(30) - 15,185 + locationNoise.nextInt(30) - 15);
      case 113:
        return new Coord(785 + locationNoise.nextInt(30) - 15,185 + locationNoise.nextInt(30) - 15);
      case 114:
        return new Coord(815 + locationNoise.nextInt(30) - 15,185 + locationNoise.nextInt(30) - 15);
      case 115:
        return new Coord(665 + locationNoise.nextInt(30) - 15,215 + locationNoise.nextInt(30) - 15);
      case 116:
        return new Coord(695 + locationNoise.nextInt(30) - 15,215 + locationNoise.nextInt(30) - 15);
      case 117:
        return new Coord(725 + locationNoise.nextInt(30) - 15,215 + locationNoise.nextInt(30) - 15);
      case 118:
        return new Coord(755 + locationNoise.nextInt(30) - 15,215 + locationNoise.nextInt(30) - 15);
      case 119:
        return new Coord(785 + locationNoise.nextInt(30) - 15,215 + locationNoise.nextInt(30) - 15);
      case 120:
        return new Coord(815 + locationNoise.nextInt(30) - 15,215 + locationNoise.nextInt(30) - 15);
    }
    return null;
  }
  //==========================================================================//


  //==========================================================================//
  // Construction
  //==========================================================================//
  public StateMovement(final Settings settings ) {
    super( settings );
  }


  public StateMovement(final StateMovement other ) {
    super( other );
  }

  @Override
  public MovementModel replicate() {
    return new StateMovement( this );
  }
  //==========================================================================//
}

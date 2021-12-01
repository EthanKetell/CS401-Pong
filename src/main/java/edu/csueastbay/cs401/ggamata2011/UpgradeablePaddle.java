package edu.csueastbay.cs401.ggamata2011;

import edu.csueastbay.cs401.pong.Paddle;

/**
 * Upgradeable Paddle that is extended from the original Paddle
 * Allows for adjustment of Height and Speed
 */
public class UpgradeablePaddle extends Paddle
{
  public final double START_SPEED = 5.0;
  public  double UPGRADE_SPEED = 0;
  public  double UPGRADE_HEIGHT = 0;

  private double topBound;
  private double bottomBound;

  enum Direction {UP, Down, STILL}
  private Direction newmove;

  /**
   * Default Constructor of Upgradeable Paddle
   * @param id sets ID of Paddle
   * @param x sets default x coordinate of Paddle on field
   * @param y sets default y coordinate of Paddle on field
   * @param width sets width of paddle
   * @param height sets height of paddle
   * @param topBound sets the Topbound in which the paddle can travel
   * @param bottomBound sets the BottomBound in which the paddle can travel
   */
  public UpgradeablePaddle(String id, double x, double y, double width, double height, double topBound, double bottomBound)
  {
      super(id,x,y,width,height,topBound,bottomBound);
      this.topBound = topBound;
      this.bottomBound = bottomBound;
  }

  /**
   *
   * @param boost
   */
  public void ModifySpeed(double boost)
  {
    UPGRADE_SPEED = UPGRADE_SPEED + boost;

    if(UPGRADE_SPEED >= 10)
    {
      UPGRADE_SPEED = 10;
    }
    else if(UPGRADE_SPEED <= (-3.5))
    {
      UPGRADE_SPEED = -3.5;
    }


  }

  /**
   *
   * @param boost
   */
  public void ModifyHeight(double boost)
  {
    UPGRADE_HEIGHT = UPGRADE_HEIGHT + boost;

    if(UPGRADE_HEIGHT >= 140)
    {
      UPGRADE_HEIGHT = 140;
    }
    else if(UPGRADE_HEIGHT <= (-40))
    {
      UPGRADE_HEIGHT = -40;
    }
    super.setHeight(getHeight()+UPGRADE_HEIGHT);
  }

  /**
   *
   */
  @Override
  public void move()
  {
    if (newmove == Direction.UP) {
      setY(getY() - (START_SPEED+UPGRADE_SPEED));
    } else if (newmove == Direction.Down) {
      setY(getY() + (START_SPEED+UPGRADE_SPEED)) ;
    }

    if (getY() < topBound) setY(topBound);
    double floor = bottomBound - getHeight();
    if (getY() > floor) setY(floor);

  }

  /**
   *
   */
  @Override
  public void stop() {
    newmove = Direction.STILL;
  }

  /**
   *
   */
  @Override
  public void moveUp() {
    newmove = Direction.UP;
  }

  /**
   *
   */
  @Override
  public void moveDown() {
    newmove = Direction.Down;
  }


}

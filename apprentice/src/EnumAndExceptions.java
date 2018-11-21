public class EnumAndExceptions {
  // Write your own ENUM type...
  public enum DisneyPark {
    DISNEYLAND(1955),
    CALIFORNIA_ADVENTURE(2001),
    MAGIC_KINGDOM(1971),
    EPCOT(1982),
    HOLLYWOOD_STUDIOS(1989),
    ANIMAL_KINGDOM(1988),
    TOKYO_DISNEYLAND(1983),
    TOKYO_DISNEYSEA(2001),
    DISNEYLAND_PARIS(1992),
    WALT_DISNEY_STUDIOS(2002),
    HONG_KONG_DISNEYLAND(2005),
    SHANGHAI_DISNEYLAND(2016);
    private int year;

    private DisneyPark(int year) {
      this.year = year;
    }
  }

  public static void main(String[] args) {
    // checked exception requires a TRY-CATCH block...
    try {
      checkedEnumsTest(DisneyPark.DISNEYLAND);
      System.out.println("Successfully called checkedEnumTest");
    } catch (BadParkException e) {
      System.out.println("BADPARKEXCEPTION received in Main");
    }

    // unchecked exception doesn't require a TRY-CATCH block...
    // uncomment next line to see exception thrown...
//    uncheckedEnumsTest("UNIVERSAL_STUDIOS");
    uncheckedEnumsTest("DISNEYLAND_PARIS");
  }

  // Write code to show exception handling including examples of checked, unchecked, and Error exceptions...
  // method for checked exception - it has a 'throws' statement
  private static void checkedEnumsTest( DisneyPark name ) throws BadParkException {
    if (isBadParkName(name)) {
      throw new BadParkException("Bad Disney park name: " + name);
    }
    for (DisneyPark dpName : DisneyPark.values()) {
      if (name.toString() == dpName.toString()) {
        System.out.println(dpName.toString() + " is the park");
      }
      System.out.println("Disney Park Year Opened: " + dpName.year + " - Disney Park Name: " + dpName);
    }
  }

  // method for checked exception...notice NO 'throws' statement
  private static void uncheckedEnumsTest( String name )  {
    if (isBadParkName(name)) {
      throw new BadParkArgException("Bad Disney park name: " + name);
    }
    for (DisneyPark dpName : DisneyPark.values()) {
      if (name == dpName.toString()) {
        System.out.println(dpName.toString() + " is the park");
      }
      System.out.println("Disney Park Year Opened: " + dpName.year + " - Disney Park Name: " + dpName);
    }
  }

  public static boolean isBadParkName (DisneyPark dpName) {
    return isBadParkName(dpName.toString());
  }

  public static boolean isBadParkName (String dpName) {
    StringBuilder sbCompanies = new StringBuilder("DISNEYLAND, CALIFORNIA_ADVENTURE, MAGIC_KINGDOM, EPCOT, HOLLYWOOD_STUDIOS, ANIMAL_KINGDOM, TOKYO_DISNEYLAND, TOKYO_DISNEYSEA, DISNEYLAND_PARIS, WALT_DISNEY_STUDIOS, HONG_KONG_DISNEYLAND, SHANGHAI_DISNEYLAND");
    if (sbCompanies.indexOf(dpName)>=0 )
      return false;
    else
      return true;
  }

  // BadArgException is an un-checked exception because it extends java.lang.RuntimeException
  public static class BadParkArgException extends RuntimeException {
    public BadParkArgException(String s) {
      super(s);
    }
  }

  // BadParkException is a checked exception because it extends java.lang.Exception
  public static class BadParkException extends Exception {
    public BadParkException(String s) {
      super(s);
    }
  }

}

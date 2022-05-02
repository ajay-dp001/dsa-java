package LowLoevelSystemDesign.parkinglot.parking;
//https://github.com/goyal27/parking-lot-lld/tree/f1fec2cccb86d0eb08c0da85cfbaf7ed7dbef8a9

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;
import lombok.Getter;
import LowLoevelSystemDesign.parkinglot.exceptions.InvalidParkingFloorException;
import LowLoevelSystemDesign.parkinglot.parking.spot.ParkingSpot;
import LowLoevelSystemDesign.parkinglot.parking.spot.ParkingSpotType;
import LowLoevelSystemDesign.parkinglot.vehicle.Vehicle;
import LowLoevelSystemDesign.parkinglot.vehicle.VehichleType;

public class ParkingFloor {

  @Getter
  private final String id;
  private final Map<String, ParkingSpot> usedParkingSpots;
  private final Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots;

  public ParkingFloor(String id) {
    this.id = id;
    parkingSpots = new HashMap<>();
    usedParkingSpots = new HashMap<>();
    parkingSpots.put(ParkingSpotType.HANDICAPPED, new ConcurrentLinkedDeque<>());
    parkingSpots.put(ParkingSpotType.SMALL_VEHICHLE, new ConcurrentLinkedDeque<>());
    parkingSpots.put(ParkingSpotType.LARGE_VEHICHLE, new ConcurrentLinkedDeque<>());
    parkingSpots.put(ParkingSpotType.ELECTRIC_CAR, new ConcurrentLinkedDeque<>());
    parkingSpots.put(ParkingSpotType.MOTOR_BIKE, new ConcurrentLinkedDeque<>());
  }

  public void addParkingSpot(final ParkingSpot parkingSpot) {
    final Optional<ParkingSpot> spot = parkingSpots.get(parkingSpot.getParkingSpotType())
        .stream()
        .filter(ps -> ps.getId().equals(parkingSpot.getId()))
        .findAny();
    if (spot.isPresent()) {
      return;
    }
    parkingSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
  }

  public synchronized ParkingSpot getParkingSpot(final Vehicle vehichle)
      throws InvalidParkingFloorException {
    final ParkingSpotType parkingSpotType = getParkingSpotTypeForVehichle(vehichle.getVehichleType());
    if (!canPark(parkingSpotType)) {
      throw new InvalidParkingFloorException("Cant find a Spot");
    }

    final ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();
    parkingSpot.assignVehichle(vehichle);
    usedParkingSpots.put(parkingSpot.getId(), parkingSpot);
    return parkingSpot;
  }

  public synchronized Optional<ParkingSpot> vacateParkingSpot(final String parkingSpotId) {
    final ParkingSpot parkingSpot = usedParkingSpots.get(parkingSpotId);
    if (Objects.nonNull(parkingSpot)) {
      parkingSpot.vacateSpot();
      parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
    }
    return Optional.ofNullable(parkingSpot);
  }

  public boolean canPark(final VehichleType vehichleType) {
    return parkingSpots.get(getParkingSpotTypeForVehichle(vehichleType)).size() > 0;
  }

  private boolean canPark(final ParkingSpotType parkingSpotTypeForVeichle) {
    return parkingSpots.get(parkingSpotTypeForVeichle).size() > 0;
  }

  private ParkingSpotType getParkingSpotTypeForVehichle(final VehichleType vehichleType) {
    switch (vehichleType) {
      case CAR:
        return ParkingSpotType.SMALL_VEHICHLE;
      case ELECTRIC:
        return ParkingSpotType.ELECTRIC_CAR;
      case MOTARBIKE:
        return ParkingSpotType.MOTOR_BIKE;
      default:
        return ParkingSpotType.LARGE_VEHICHLE;
    }
  }
}

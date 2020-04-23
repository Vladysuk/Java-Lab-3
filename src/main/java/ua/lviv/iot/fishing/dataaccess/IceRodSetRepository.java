package ua.lviv.iot.fishing.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.fishing.model.IceRodSet;

@Repository
public interface IceRodSetRepository extends JpaRepository<IceRodSet, Integer> {
}

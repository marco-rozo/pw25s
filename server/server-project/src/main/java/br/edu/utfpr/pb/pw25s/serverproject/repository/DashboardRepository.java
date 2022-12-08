package br.edu.utfpr.pb.pw25s.serverproject.repository;

import br.edu.utfpr.pb.pw25s.serverproject.dto.ExpensesDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.ReceiptsDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<Movement, Long> {
    @Query(value = "SELECT count(id) as numExpenses, coalesce(sum(value),0) as totalvalues, coalesce(sum(amount_paid),0) as totalpaid FROM movement WHERE movement.type='1' and account_id = :accountId", nativeQuery = true)
    List<Object[]> findDataExpenses(Long accountId);

    @Query(value = "SELECT count(id) as numreceipts, coalesce(sum(value),0) as valuereceipts, coalesce(sum(amount_paid), 0) as valuereceived FROM movement WHERE movement.type='0' and account_id = :accountId", nativeQuery = true)
    List<Object[]> findDataReceipts(Long accountId);
}

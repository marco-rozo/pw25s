package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.DashboardDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.ExpensesDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.ReceiptsDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DashboardService {


    ReceiptsDto findReceiptsData();

    ExpensesDto findExpensesData();

    DashboardDto findData();

    List<CategoryDto> findAll();

    Long count();

    Boolean exists(Long id);
}

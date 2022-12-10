package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.DashboardDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.ExpensesDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.ReceiptsDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.AccountRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.DashboardRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.DashboardService;
import br.edu.utfpr.pb.pw25s.serverproject.shared.SecurityContextShared;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {
    private final DashboardRepository dashboardRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final SecurityContextShared securityContextShared;
    private ModelMapper modelMapper;

    public DashboardServiceImpl(DashboardRepository dashboardRepository, ModelMapper modelMapper, UserRepository userRepository, AccountRepository accountRepository, SecurityContextShared securityContextShared) {
        this.dashboardRepository = dashboardRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.securityContextShared = securityContextShared;
    }

    @Override
    public ReceiptsDto findReceiptsData() {
        Object principal = securityContextShared.getPincipal();

        User u = userRepository.findByEmail(principal.toString());

        List<Account> accounts = accountRepository.findAccountsByUser(u);
        ReceiptsDto r = new ReceiptsDto();

        if (accounts.size() > 0){
            for(Account account : accounts){
                System.out.println(account.getName());
                System.out.println(account.getName());
                Object[] obj = dashboardRepository.findDataReceipts(account.getId()).get(0);
                if(r.getNumReceipts() == null){
                    r.setNumReceipts(Integer.parseInt(obj[0].toString()));
                    r.setValueReceipts((Double) obj[1]);
                    r.setValueReceived((Double) obj[2]);
                } else {
                    Integer numReceipts = r.getNumReceipts();
                    Double valueReceipts = r.getValueReceipts();
                    Double valueReceived = r.getValueReceived();

                    numReceipts += Integer.parseInt(obj[0].toString());
                    valueReceipts += (Double) obj[1];
                    valueReceived += (Double) obj[2];

                    r.setNumReceipts(numReceipts);
                    r.setValueReceipts(valueReceipts);
                    r.setValueReceived(valueReceived);
                }
            }
        }

        return r;
    }

    @Override
    public ExpensesDto findExpensesData() {
        Object principal = securityContextShared.getPincipal();

        User u = userRepository.findByEmail(principal.toString());

        List<Account> accounts = accountRepository.findAccountsByUser(u);
        ExpensesDto e = new ExpensesDto();

        if (accounts.size() > 0){
            for(Account account : accounts){
                System.out.println(account.getName());
                System.out.println(account.getName());
                Object[] obj = dashboardRepository.findDataExpenses(account.getId()).get(0);
                if(e.getNumExpenses() == null){
                    e.setNumExpenses(Integer.parseInt(obj[0].toString()));
                    e.setValueExpenses((Double) obj[1]);
                    e.setValuePaid((Double) obj[2]);
                } else {
                    Integer numExpenses = e.getNumExpenses();
                    Double valueExpenses = e.getValueExpenses();
                    Double valuePaid = e.getValuePaid();

                    numExpenses += Integer.parseInt(obj[0].toString());
                    valueExpenses += (Double) obj[1];
                    valuePaid += (Double) obj[2];

                    e.setNumExpenses(numExpenses);
                    e.setValueExpenses(valueExpenses);
                    e.setValuePaid(valuePaid);
                }
            }
        }

        return e;
    }

    @Override
    public DashboardDto findData() {
        ReceiptsDto r = this.findReceiptsData();
        ExpensesDto e = this.findExpensesData();

        DashboardDto dash = new DashboardDto();
        dash.setNumReceipts(r.getNumReceipts());
        dash.setValueTotalReceipts(r.getValueReceipts());
        dash.setValueTotalReceived(r.getValueReceived());
        dash.setValueRemainingReceipts(r.getValueReceipts() - r.getValueReceived());


        dash.setNumExpenses(e.getNumExpenses());
        dash.setValueTotalExpenses(e.getValueExpenses());
        dash.setValueTotalExpensesPaid(e.getValuePaid());
        dash.setValueRemainingExpenses(e.getValueExpenses() - e.getValuePaid());

        dash.setBalance(dash.getValueTotalReceipts() - dash.getValueRemainingExpenses());

        return dash;
    }


    @Override
    public List<CategoryDto> findAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Boolean exists(Long id) {
        return null;
    }
}

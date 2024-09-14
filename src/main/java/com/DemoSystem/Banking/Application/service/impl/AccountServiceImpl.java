package com.DemoSystem.Banking.Application.service.impl;

import com.DemoSystem.Banking.Application.dto.AccountDto;
import com.DemoSystem.Banking.Application.entity.Account;
import com.DemoSystem.Banking.Application.mapper.AccountMapper;
import com.DemoSystem.Banking.Application.repository.PrimaryRepository;
import com.DemoSystem.Banking.Application.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private PrimaryRepository accountRepository;

    public AccountServiceImpl(PrimaryRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccount(savedAccount);
    }

    @Override
    public AccountDto findAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("No results found for this ID"));
        return AccountMapper.mapToAccount(account);

    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("No results found for this ID"));

        double totalAmount= account.getBalance() +amount;
        account.setBalance(totalAmount);
        Account accountAfterDeposit = accountRepository.save(account);
        return AccountMapper.mapToAccount(accountAfterDeposit);
    }

    @Override
    public Integer StreamTest(Long id){
// Streams api can be used with collection/group of data list,arrays etc

        // this way we can create an immutable(fixed size) list. If we try to add it will throw runtime exception
        List<Integer> immutableList = List.of(1, 2, 3, 34, 678, 6789, 78907, 890798, 78);
        List<Integer> immutableArrayList = Arrays.asList(1, 2, 3, 34, 678, 6789, 78907, 890798, 78);

        // other way we can create a mutable list. We can use add function to add elements to it

        List<Integer> mutableList = new ArrayList<>();
         mutableList.add(1);
         mutableList.add(2);
         mutableList.add(3);
         mutableList.add(4);
         mutableList.add(5);
         mutableList.add(6);
         mutableList.add(7);
         mutableList.add(8);

        Stream<Integer> streamofList = mutableList.stream();
        log.info("Unfiltered List v1 integer "+mutableList);

        List<Integer> FilteredList =streamofList.filter(i -> i % 2==0).collect(Collectors.toList());
        log.info("Stream v1 integer "+FilteredList);


        Stream<Object> emptyStream = Stream.empty();
        emptyStream.forEach(e-> {
            log.info("inside empty Streams");
        });
        // 2d array objects, collection sample
        String names[] ={"ALSI BHEDIA", "BHUKA BHEDIA","CHINNAR BHEDIA","DOGLA BHEDIA","EKLOTA BHEDIA","FUDU BHEDIA"};
        Stream<String> namesStream = Stream.of(names);
        namesStream.forEach(i->{log.info(i);});

        // when using Builder we need to add .build

        Stream<Object> streamBuilder = Stream.builder().build();

//   TODO Try out filter works on predicates
//          filter(Predicate) a Predicate is a function that returns boolean result(interface function). filter basically decides for east attribute
//     we can use a lambda function like e -> {} if we add curly braces then we need return statement else we can do e -> e>10

//   TODO Try out :-We use MAP to perform some operation on element then return the same element
//        map(Function) it performs function on each element then returns it

        List<String> name =List.of("ALSI BHEDIA", "BHUKA BHEDIA","CHINNAR BHEDIA","DOGLA BHEDIA","EKLOTA BHEDIA","FUDU BHEDIA");
        List<String> nameStreams = name.stream().filter(e -> e.startsWith("A")).collect(Collectors.toList());
        AccountDto accountDto1 = new AccountDto(1123123L,"Test1",2122934567.09);
        AccountDto accountDto2 = new AccountDto(12133123L,"Test2",212293234.09);
        AccountDto accountDto3= new AccountDto(123124523L,"Test3",212223493.09);
        AccountDto accountDto4 = new AccountDto(234123123L,"Test4",212342293.09);
        AccountDto accountDto5 = new AccountDto(234123123L,"Test5",22312293.09);
        AccountDto accountDto6 = new AccountDto(9878123123L,"Test6",212293234.09);
        AccountDto accountDto7 = new AccountDto(796123123L,"Test7",212292343.09);
        AccountDto accountDto8 = new AccountDto(145623123L,"Test8",21222393.09);
        AccountDto accountDto9 = new AccountDto(9641423123L,"Test9",212223493.09);



        Optional<AccountDto> ObjectStreamtest = Optional.ofNullable(accountDto1);
        List<AccountDto> Accounts =new ArrayList<>();
        Accounts.add(accountDto1);
        Accounts.add(accountDto2);
        Accounts.add(accountDto3);
        Accounts.add(accountDto4);
        Accounts.add(accountDto5);
        Accounts.add(accountDto6);
        Accounts.add(accountDto7);
        Accounts.add(accountDto8);
        Accounts.add(accountDto9);
        List<AccountDto> Accounts2 =Accounts;

//        List<AccountDto> ObjectArrayStream = Accounts.stream().parallel().map(e-> e.getBalance()>1000).collect(Collectors.toList());
        List<AccountDto> filteredPeople = Accounts.stream()
                .filter(e -> e.getBalance() > 24)
                .collect(Collectors.toList());
//        List<String> filteredId = Accounts2.stream()
//                .filter(e -> {e.getBalance() >2000}).map()
//                .collect(Collectors.toList());


        log.info(nameStreams.toString());
        return 1;

    }


}

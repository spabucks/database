package sphabucks.payments.gifticons.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sphabucks.payments.gifticons.model.GiftIconList;
import sphabucks.payments.gifticons.repository.IGiftIconListRepo;
import sphabucks.payments.gifticons.repository.IGiftIconRepository;
import sphabucks.payments.gifticons.vo.RequestGiftIconList;
import sphabucks.users.repository.IUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftIconListServiceImpl implements IGiftIconListService{

    private final IGiftIconListRepo iGiftIconListRepo;
    private final IGiftIconRepository iGiftIconRepository;
    private final IUserRepository iUserRepository;
    @Override
    public void addGiftIconList(RequestGiftIconList requestGiftIconList) {
        GiftIconList giftIconList = GiftIconList.builder()
                .giftIcon(iGiftIconRepository.findById(requestGiftIconList.getGiftIconId()).get())
                .user(iUserRepository.findById(requestGiftIconList.getUserId()).get())
                .build();
        iGiftIconListRepo.save(giftIconList);
    }

    @Override
    public List<GiftIconList> getGiftIconList(Long id) {
        return iGiftIconListRepo.findAllByUserUserId(iUserRepository.findById(id).get().getUserId());
    }
}

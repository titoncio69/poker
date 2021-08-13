package com.poker.backend.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.backend.rest.service.IManosPokerService;
import com.poker.backend.rest.utils.MetodosUtiles;

@Service
public class ManosPokerServiceImpl implements IManosPokerService {

	@Autowired
	private MetodosUtiles util;

	@Override
	public Boolean royalFlush(String[] mano) {
		boolean mismaPinta = util.encontrarCartasMismaPinta(mano);
		if (mismaPinta) {
			boolean royalFlush = util.royalFlush(mano) ? true : false;
			if (royalFlush) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean straightFlush(String[] mano) {
		boolean mismaPinta = util.encontrarCartasMismaPinta(mano);
		if (mismaPinta) {
			boolean consecutivos = util.encontrarOrdenNumerico(mano) ? true : false;
			if (consecutivos) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean fourOfAKind(String[] mano) {
		return util.encontrarCuatroIguales(mano);
	}

	@Override
	public Boolean fullHouse(String[] mano) {
		return util.encontrarFullHouse(mano);
	}

	@Override
	public Boolean flush(String[] mano) {
		return util.encontrarCartasMismaPinta(mano);
	}

	@Override
	public Boolean Straight(String[] mano) {
		if (util.encontrarOrdenNumerico(mano) || util.royalFlush(mano)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean threeOfAKind(String[] mano) {
		return util.encontrarTrio(mano);
	}

	@Override
	public Boolean twoPair(String[] mano) {
		return util.encontrarDosPares(mano);
	}

	@Override
	public Boolean onePair(String[] mano) {
		return util.encontrarUnPar(mano);
	}

	@Override
	public String highCard(String[] mano) {
		return util.encontrarMasAlta(mano);
	}
}

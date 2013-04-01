package com.yueyun.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbArtist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbArtist
 * @author MyEclipse Persistence Tools
 */

public class TbArtistDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbArtistDAO.class);
	// property constants
	public static final String ARTIST_NAME = "artistName";
	public static final String ARTIST_IMG_SMALL = "artistImgSmall";
	public static final String ARTIST_IMG_MEDIUM = "artistImgMedium";
	public static final String ARTIST_IMG_LARGE = "artistImgLarge";

	protected void initDao() {
		// do nothing
	}

	public void save(TbArtist transientInstance) {
		log.debug("saving TbArtist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbArtist persistentInstance) {
		log.debug("deleting TbArtist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbArtist findById(java.lang.String id) {
		log.debug("getting TbArtist instance with id: " + id);
		try {
			TbArtist instance = (TbArtist) getHibernateTemplate().get(
					"com.yueyun.dao.TbArtist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbArtist instance) {
		log.debug("finding TbArtist instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbArtist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbArtist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByArtistName(Object artistName) {
		return findByProperty(ARTIST_NAME, artistName);
	}

	public List findByArtistImgSmall(Object artistImgSmall) {
		return findByProperty(ARTIST_IMG_SMALL, artistImgSmall);
	}

	public List findByArtistImgMedium(Object artistImgMedium) {
		return findByProperty(ARTIST_IMG_MEDIUM, artistImgMedium);
	}

	public List findByArtistImgLarge(Object artistImgLarge) {
		return findByProperty(ARTIST_IMG_LARGE, artistImgLarge);
	}

	public List findAll() {
		log.debug("finding all TbArtist instances");
		try {
			String queryString = "from TbArtist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbArtist merge(TbArtist detachedInstance) {
		log.debug("merging TbArtist instance");
		try {
			TbArtist result = (TbArtist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbArtist instance) {
		log.debug("attaching dirty TbArtist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbArtist instance) {
		log.debug("attaching clean TbArtist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbArtistDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbArtistDAO) ctx.getBean("TbArtistDAO");
	}
}
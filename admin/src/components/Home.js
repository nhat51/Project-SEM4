const Home = () => {
    return (
        <div class="page-container">
            <div className="main-content">
                <div className="section__content section__content--p30">
                    <div className="container-fluid">
                        <div className="row">
                            <div className="col-md-12">
                                <div className="overview-wrap">
                                    <h2 className="title-1">overview</h2>
                                </div>
                            </div>
                        </div>
                        <div className="row m-t-25">
                            <div className="col-sm-6 col-lg-3">
                                <div className="overview-item overview-item--c1">
                                    <div className="overview__inner">
                                        <div className="overview-box clearfix">
                                            <div className="icon">
                                                <i className="zmdi zmdi-account-o"></i>
                                            </div>
                                            <div className="text">
                                                <h2>10368</h2>
                                                <span>members online</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6 col-lg-3">
                                <div className="overview-item overview-item--c2">
                                    <div className="overview__inner">
                                        <div className="overview-box clearfix">
                                            <div className="icon">
                                                <i className="zmdi zmdi-shopping-cart"></i>
                                            </div>
                                            <div className="text">
                                                <h2>388,688</h2>
                                                <span>items solid</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6 col-lg-3">
                                <div className="overview-item overview-item--c3">
                                    <div className="overview__inner">
                                        <div className="overview-box clearfix">
                                            <div className="icon">
                                                <i className="zmdi zmdi-calendar-note"></i>
                                            </div>
                                            <div className="text">
                                                <h2>1,086,789</h2>
                                                <span>this week</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6 col-lg-3">
                                <div className="overview-item overview-item--c4">
                                    <div className="overview__inner">
                                        <div className="overview-box clearfix">
                                            <div className="icon">
                                                <i className="zmdi zmdi-money"></i>
                                            </div>
                                            <div className="text">
                                                <h2>$1,060,386</h2>
                                                <span>total earnings</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-lg-9">
                                <h2 className="title-1 m-b-25">Earnings By Items</h2>
                                <div className="table-responsive table--no-card m-b-40">
                                    <table className="table table-borderless table-striped table-earning">
                                        <thead>
                                        <tr>
                                            <th>date</th>
                                            <th>order ID</th>
                                            <th>name</th>
                                            <th className="text-right">price</th>
                                            <th className="text-right">quantity</th>
                                            <th className="text-right">total</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>2018-09-29 05:57</td>
                                            <td>100398</td>
                                            <td>iPhone X 64Gb Grey</td>
                                            <td className="text-right">$999.00</td>
                                            <td className="text-right">1</td>
                                            <td className="text-right">$999.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-28 01:22</td>
                                            <td>100397</td>
                                            <td>Samsung S8 Black</td>
                                            <td className="text-right">$756.00</td>
                                            <td className="text-right">1</td>
                                            <td className="text-right">$756.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-27 02:12</td>
                                            <td>100396</td>
                                            <td>Game Console Controller</td>
                                            <td className="text-right">$22.00</td>
                                            <td className="text-right">2</td>
                                            <td className="text-right">$44.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-26 23:06</td>
                                            <td>100395</td>
                                            <td>iPhone X 256Gb Black</td>
                                            <td className="text-right">$1199.00</td>
                                            <td className="text-right">1</td>
                                            <td className="text-right">$1199.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-25 19:03</td>
                                            <td>100393</td>
                                            <td>USB 3.0 Cable</td>
                                            <td className="text-right">$10.00</td>
                                            <td className="text-right">3</td>
                                            <td className="text-right">$30.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-29 05:57</td>
                                            <td>100392</td>
                                            <td>Smartwatch 4.0 LTE Wifi</td>
                                            <td className="text-right">$199.00</td>
                                            <td className="text-right">6</td>
                                            <td className="text-right">$1494.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-24 19:10</td>
                                            <td>100391</td>
                                            <td>Camera C430W 4k</td>
                                            <td className="text-right">$699.00</td>
                                            <td className="text-right">1</td>
                                            <td className="text-right">$699.00</td>
                                        </tr>
                                        <tr>
                                            <td>2018-09-22 00:43</td>
                                            <td>100393</td>
                                            <td>USB 3.0 Cable</td>
                                            <td className="text-right">$10.00</td>
                                            <td className="text-right">3</td>
                                            <td className="text-right">$30.00</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div className="col-lg-3">
                                <h2 className="title-1 m-b-25">Top countries</h2>
                                <div className="au-card au-card--bg-blue au-card-top-countries m-b-40">
                                    <div className="au-card-inner">
                                        <div className="table-responsive">
                                            <table className="table table-top-countries">
                                                <tbody>
                                                <tr>
                                                    <td>United States</td>
                                                    <td className="text-right">$119,366.96</td>
                                                </tr>
                                                <tr>
                                                    <td>Australia</td>
                                                    <td className="text-right">$70,261.65</td>
                                                </tr>
                                                <tr>
                                                    <td>United Kingdom</td>
                                                    <td className="text-right">$46,399.22</td>
                                                </tr>
                                                <tr>
                                                    <td>Turkey</td>
                                                    <td className="text-right">$35,364.90</td>
                                                </tr>
                                                <tr>
                                                    <td>Germany</td>
                                                    <td className="text-right">$20,366.96</td>
                                                </tr>
                                                <tr>
                                                    <td>France</td>
                                                    <td className="text-right">$10,366.96</td>
                                                </tr>
                                                <tr>
                                                    <td>Australia</td>
                                                    <td className="text-right">$5,366.96</td>
                                                </tr>
                                                <tr>
                                                    <td>Italy</td>
                                                    <td className="text-right">$1639.32</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-md-12">

                                <h3 className="title-5 m-b-35">data table</h3>
                                <div className="table-data__tool">
                                    <div className="table-data__tool-left">
                                        <div className="rs-select2--light rs-select2--md">
                                            <select className="js-select2" name="property">
                                                <option selected="selected">All Properties</option>
                                                <option value="">Option 1</option>
                                                <option value="">Option 2</option>
                                            </select>
                                            <div className="dropDownSelect2"></div>
                                        </div>
                                        <div className="rs-select2--light rs-select2--sm">
                                            <select className="js-select2" name="time">
                                                <option selected="selected">Today</option>
                                                <option value="">3 Days</option>
                                                <option value="">1 Week</option>
                                            </select>
                                            <div className="dropDownSelect2"></div>
                                        </div>
                                        <button className="au-btn-filter">
                                            <i className="zmdi zmdi-filter-list"></i>filters
                                        </button>
                                    </div>
                                </div>
                                <div className="table-responsive table-responsive-data2">
                                    <table className="table table-data2">
                                        <thead>
                                        <tr>
                                            <th>
                                                <label className="au-checkbox">
                                                    <input type="checkbox"/>
                                                    <span className="au-checkmark"></span>
                                                </label>
                                            </th>
                                            <th>name</th>
                                            <th>email</th>
                                            <th>description</th>
                                            <th>date</th>
                                            <th>status</th>
                                            <th>price</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr className="tr-shadow">
                                            <td>
                                                <label className="au-checkbox">
                                                    <input type="checkbox"/>
                                                    <span className="au-checkmark"></span>
                                                </label>
                                            </td>
                                            <td>Lori Lynch</td>
                                            <td>
                                                <span className="block-email">lori@example.com</span>
                                            </td>
                                            <td className="desc">Samsung S8 Black</td>
                                            <td>2018-09-27 02:12</td>
                                            <td>
                                                <span className="status--process">Processed</span>
                                            </td>
                                            <td>$679.00</td>
                                            <td>
                                                <div className="table-data-feature">
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Send">
                                                        <i className="zmdi zmdi-mail-send"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Edit">
                                                        <i className="zmdi zmdi-edit"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Delete">
                                                        <i className="zmdi zmdi-delete"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="More">
                                                        <i className="zmdi zmdi-more"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr className="spacer"></tr>
                                        <tr className="tr-shadow">
                                            <td>
                                                <label className="au-checkbox">
                                                    <input type="checkbox"/>
                                                    <span className="au-checkmark"></span>
                                                </label>
                                            </td>
                                            <td>Lori Lynch</td>
                                            <td>
                                                <span className="block-email">john@example.com</span>
                                            </td>
                                            <td className="desc">iPhone X 64Gb Grey</td>
                                            <td>2018-09-29 05:57</td>
                                            <td>
                                                <span className="status--process">Processed</span>
                                            </td>
                                            <td>$999.00</td>
                                            <td>
                                                <div className="table-data-feature">
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Send">
                                                        <i className="zmdi zmdi-mail-send"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Edit">
                                                        <i className="zmdi zmdi-edit"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Delete">
                                                        <i className="zmdi zmdi-delete"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="More">
                                                        <i className="zmdi zmdi-more"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr className="spacer"></tr>
                                        <tr className="tr-shadow">
                                            <td>
                                                <label className="au-checkbox">
                                                    <input type="checkbox"/>
                                                    <span className="au-checkmark"></span>
                                                </label>
                                            </td>
                                            <td>Lori Lynch</td>
                                            <td>
                                                <span className="block-email">lyn@example.com</span>
                                            </td>
                                            <td className="desc">iPhone X 256Gb Black</td>
                                            <td>2018-09-25 19:03</td>
                                            <td>
                                                <span className="status--denied">Denied</span>
                                            </td>
                                            <td>$1199.00</td>
                                            <td>
                                                <div className="table-data-feature">
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Send">
                                                        <i className="zmdi zmdi-mail-send"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Edit">
                                                        <i className="zmdi zmdi-edit"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Delete">
                                                        <i className="zmdi zmdi-delete"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="More">
                                                        <i className="zmdi zmdi-more"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr className="spacer"></tr>
                                        <tr className="tr-shadow">
                                            <td>
                                                <label className="au-checkbox">
                                                    <input type="checkbox"/>
                                                    <span className="au-checkmark"></span>
                                                </label>
                                            </td>
                                            <td>Lori Lynch</td>
                                            <td>
                                                <span className="block-email">doe@example.com</span>
                                            </td>
                                            <td className="desc">Camera C430W 4k</td>
                                            <td>2018-09-24 19:10</td>
                                            <td>
                                                <span className="status--process">Processed</span>
                                            </td>
                                            <td>$699.00</td>
                                            <td>
                                                <div className="table-data-feature">
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Send">
                                                        <i className="zmdi zmdi-mail-send"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Edit">
                                                        <i className="zmdi zmdi-edit"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="Delete">
                                                        <i className="zmdi zmdi-delete"></i>
                                                    </button>
                                                    <button className="item" data-toggle="tooltip" data-placement="top"
                                                            title="More">
                                                        <i className="zmdi zmdi-more"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <br/>
                                    <nav aria-label="Page navigation example">
                                        <ul className="pagination justify-content-end">
                                            <li className="page-item disabled">
                                                <a className="page-link" href="#" tabIndex="-1">Previous</a>
                                            </li>
                                            <li className="page-item"><a className="page-link" href="#">1</a></li>
                                            <li className="page-item"><a className="page-link" href="#">2</a></li>
                                            <li className="page-item"><a className="page-link" href="#">3</a></li>
                                            <li className="page-item">
                                                <a className="page-link" href="#">Next</a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Home
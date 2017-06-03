exports.myMiddleware = (req, res, next) => {
	req.name = 'Don';
	if(req.name === 'Don') {
		throw Error('That is a stupid name');
	}
	next();
};

exports.homePage = (req, res) => {
	console.log(req.name);
	res.render('index');
};